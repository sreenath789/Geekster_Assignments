package com.example.InstagramAppBackend.Service;

import com.example.InstagramAppBackend.Model.AuthenticationToken;
import com.example.InstagramAppBackend.Model.Post;
import com.example.InstagramAppBackend.Model.User;
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


    public List<Post> getAllPosts(String email) {
        User postOwner = iUserRepo.findFirstByUserEmail(email);
        return postService.getAllPosts(postOwner);
    }

//    private String userName;
//    private String userHandle;
//    private String userBio;
//    @Pattern(regexp = "^.+@(?![Ii][Nn][Ss][Tt][Aa][Aa][Dd][Mm][Ii][Nn]\\.[Cc][Oo][Mm]$).+$")
//    @Column(unique = true)
//    private String userEmail;
//    @NotBlank
//    private String userPassword;
//    @Enumerated(EnumType.STRING)
//    private Gender gender;
//    @Enumerated(EnumType.STRING)
//    private AccountType accountType;

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
}
