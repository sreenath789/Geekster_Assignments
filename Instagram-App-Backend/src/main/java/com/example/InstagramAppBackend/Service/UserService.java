package com.example.InstagramAppBackend.Service;

import com.example.InstagramAppBackend.Model.*;
import com.example.InstagramAppBackend.Model.dto.SignInInput;
import com.example.InstagramAppBackend.Model.dto.SignUpOutput;
import com.example.InstagramAppBackend.Model.enums.AccountType;
import com.example.InstagramAppBackend.Model.enums.Gender;
import com.example.InstagramAppBackend.Repo.IUserRepo;
import com.example.InstagramAppBackend.Service.utility.emailutility.EmailHandler;
import com.example.InstagramAppBackend.Service.utility.hashingutility.PasswordEncrypter;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepo iUserRepo;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @Autowired
    LikeService likeService;

    @Autowired
    FollowService followService;

    public SignUpOutput signUpUser(User user) {
        //signup email
        String signUpEmail = user.getUserEmail();

        //check mail is valid or null
        if(signUpEmail==null){
            return new SignUpOutput(false,"Invalid Email!!!");
        }

        //check if user is already exists
        User existingUser = iUserRepo.findFirstByUserEmail(signUpEmail);
        if(existingUser!=null){
            return new SignUpOutput(false,"Email Already Exists please sign in!");
        }

        //save the user if user not exists
        try{
            String encryptPassword = PasswordEncrypter.getEncryptPassword(user.getUserPassword());
            user.setUserPassword(encryptPassword);
            iUserRepo.save(user);
            return new SignUpOutput(true,"Account Created Successfully!");
        }
        catch (Exception e){
            return new SignUpOutput(false,"Internal Error Occurred");
        }



    }

    public String signInUser(SignInInput signInInput) {
        String signInStatusMessage = null;
        String signInMail = signInInput.getEmail();

        //checks mail is valid or not
        if(signInMail==null){
            signInStatusMessage = "Invalid Mail";
            return signInStatusMessage;
        }

        //checks user is exists or not
        User existingUser = iUserRepo.findFirstByUserEmail(signInMail);
        if(existingUser==null){
            signInStatusMessage = "Email not registered please sign up first";
            return signInStatusMessage;
        }

        //if user exists and send authentication token
        try {
            String encryptedPassword = PasswordEncrypter.getEncryptPassword(signInInput.getPassword());
            if(existingUser.getUserPassword().equals(encryptedPassword)){
                AuthenticationToken authenticationToken = new AuthenticationToken(existingUser);
                authenticationService.saveToken(authenticationToken);

                EmailHandler.sendEmail(signInMail,"Authentication Code",authenticationToken.getTokenValue());
                signInStatusMessage = "Authentication code sent to your email!";
                return signInStatusMessage;
            }
            else{
                signInStatusMessage = "Invalid Credentials";
                return signInStatusMessage;
            }
        }
        catch (Exception e){
            signInStatusMessage = "Internal Error occurred during sign in!";
            return signInStatusMessage;
        }
    }

    public String signOutUser(String email) {
        User user = iUserRepo.findFirstByUserEmail(email);
        AuthenticationToken authenticationToken = authenticationService.findFirstByUser(user);
        authenticationService.remove(authenticationToken);
        return "Signed out Successfully!";
    }

    public String createInstaPost(Post post, String email) {
        User postOwner = iUserRepo.findFirstByUserEmail(email);
        post.setPostOwner(postOwner);
        return postService.createInstaPost(post);
    }




    public boolean updateUser(User user) {
        User existingUser = iUserRepo.findFirstByUserEmail(user.getUserEmail());
        if(existingUser!=null){
          if(user.getUserName()!=null){
              existingUser.setUserName(user.getUserName());
          }
          iUserRepo.save(existingUser);
          return true;
        }
        return false;
    }

    public String removeInstaPost(Integer postId, String email) {
        User user = iUserRepo.findFirstByUserEmail(email);
        return postService.removeInstaPost(postId,user);
    }

    public String addComment(Comment comment, String commenterEmail) {
        boolean validPost = postService.validatePost(comment.getInstaPost());
        if(validPost){
            User commenter = iUserRepo.findFirstByUserEmail(commenterEmail);
            comment.setCommentUser(commenter);
            return commentService.addComment(comment);
        }
        else{
            return "Cannot comment on Invalid Post!!";
        }
    }

    public String removeInstaComment(Integer commentId, String email) {
        Comment comment = commentService.findComment(commentId);
        if(comment!=null){
            if(authoriseCommentRemover(comment,email)){
                commentService.removeInstaComment(comment);
                return "Comment deleted";
            }
            else{
                return "Unauthorized delete detected...Not allowed!!!!";
            }
        }
        else{
            return "Invalid comment";
        }
    }

    boolean authoriseCommentRemover(Comment comment, String email) {
        String commenterMail = comment.getCommentUser().getUserEmail();
        String postOwnerMail = comment.getInstaPost().getPostOwner().getUserEmail();
        return postOwnerMail.equals(email) || commenterMail.equals(email);
    }

    public String addLike(Like like, String likerEmail) {
        Post post = like.getInstaPost();
        boolean validPost = postService.validatePost(post);
        if(validPost){
            User liker = iUserRepo.findFirstByUserEmail(likerEmail);
            if(likeService.isLikeAllowedOnThisPost(post,liker)){
                like.setLiker(liker);
                likeService.addLike(like);
                return "liked";
            }
            else{
                return "Already liked!!!";
            }
        }
        else{
            return "Cannot like on invalid post!";
        }

    }

    public String getLikeCountForPost(Integer postId) {
        Post post = postService.getPostById(postId);
        if(post!=null){
            Integer likes = likeService.getLikeCountForPost(post);
            return String.valueOf(likes);
        }
        else{
            return "Invalid post!!!";
        }
    }

    public String removeInstaLike(Integer likeId, String email) {
        Like like = likeService.getLikeById(likeId);
        if(like!=null){
            if(authoriseLikeRemover(like,email)){
                likeService.removeLike(like);
                return "like removed!!!";
            }
            else {
                return "Unauthorized remove detected...Not allowed!!!!";
            }
        }
        else{
            return "Invalid Like!!!";
        }
    }

    private boolean authoriseLikeRemover(Like like, String email) {
        String likerOwnerMail = like.getLiker().getUserEmail();
        return likerOwnerMail.equals(email);
    }

    public String followUser(Follow follow, String followerEmail) {
        User followTargetUser = iUserRepo.findById(follow.getCurrentUser().getUserId()).orElse(null);
        User follower = iUserRepo.findFirstByUserEmail(followerEmail);

        if(followTargetUser!=null){
            if(followService.isFollowAllowed(followTargetUser,follower)){
                followService.startFollowing(follow,follower);
                return follower.getUserHandle()  + " is now following " + followTargetUser.getUserHandle();
            }
            else if(followTargetUser.equals(follower)){
                return "you cant follow to your own account";
            }
            else{
                return follower.getUserHandle()  + " is Already following " + followTargetUser.getUserHandle();
            }
        }
        else{
            return "Target User not found!!!";
        }
    }

    public String unFollowUser(Integer followId, String followerEmail) {
        Follow follow = followService.findFollow(followId);
        if(follow!=null){
            if(authoriseUnfollowUser(follow,followerEmail)){
                followService.unFollow(follow);
                return follow.getCurrentUser().getUserHandle() +"not followed by"+iUserRepo.findFirstByUserEmail(followerEmail).getUserHandle();
            }
            else{
                return "Unauthorized unfollow detected...Not allowed!!!!";
            }
        }
        else{
            return "Invalid Follow Mapping";
        }
    }

    private boolean authoriseUnfollowUser(Follow follow, String email) {
        String targetMail = follow.getCurrentUser().getUserEmail();
        String followerMail = follow.getCurrentUserFollower().getUserEmail();
        return targetMail.equals(email) || followerMail.equals(email);
    }
}
