package com.example.InstagramAppBackend.Controller;

import com.example.InstagramAppBackend.Model.*;
import com.example.InstagramAppBackend.Model.dto.SignInInput;
import com.example.InstagramAppBackend.Model.dto.SignUpOutput;
import com.example.InstagramAppBackend.Service.AuthenticationService;
import com.example.InstagramAppBackend.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;

    //operations of sign in , sign up and sign out
    @PostMapping("user/signup")
    public SignUpOutput signUpInstaUser(@RequestBody User user)
    {
        return userService.signUpUser(user);
    }

    @PostMapping("user/signin")
    public String signInInstaUser(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.signInUser(signInInput);
    }

    @DeleteMapping("user/signout")
    public String signOutInstaUser(String email,String token){
        if(authenticationService.authenticate(email,token)){
            return userService.signOutUser(email);
        }
        return "sign out not allowed for non-authenticate user";
    }

    @PutMapping("user/update")
    public boolean updateUser(@RequestBody User user,String token,String mail){
        if(authenticationService.authenticate(user.getUserEmail(),token)){
            return userService.updateUser(user);
        }
        return false;
    }

    //create post, remove post
    @PostMapping("post")
    public String createInstaPost(@RequestBody Post post, @RequestParam String email, @RequestParam String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.createInstaPost(post,email);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }

    @DeleteMapping("post")
    public String removeInstaPost(@RequestParam Integer postId,@RequestParam String email,@RequestParam String token){
        if(authenticationService.authenticate(email,token)) {
            return userService.removeInstaPost(postId,email);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }

    //Commenting functionalities on instagram
    @PostMapping("comment")
    public String addComment(@RequestBody Comment comment,@RequestParam String commenterEmail,@RequestParam String token){
        if(authenticationService.authenticate(commenterEmail,token)) {
            return userService.addComment(comment,commenterEmail);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }

    @DeleteMapping("comment")
    public String removeInstaComment(@RequestParam Integer commentId,@RequestParam String email,@RequestParam String token)
    {
        if(authenticationService.authenticate(email,token)){
            return userService.removeInstaComment(commentId,email);
        }
        else{
            return "Not an Authenticated user activity!!!";
        }
    }

    //like functionalities
    @PostMapping("like")
    public String addLike(@RequestBody Like like,@RequestParam String likerEmail,@RequestParam String token){
        if(authenticationService.authenticate(likerEmail,token)){
            return userService.addLike(like,likerEmail);
        }
        else{
            return "Not an Authenticated user activity!!!";
        }
    }

    @GetMapping("like/count/post/{postId}")
    public String getLikeCountForPost(@PathVariable Integer postId,@RequestParam String email,@RequestParam String token){
        if(authenticationService.authenticate(email,token)){
            return userService.getLikeCountForPost(postId);
        }
        else{
            return "Not an Authenticated user activity!!!";
        }
    }

    @DeleteMapping("like")
    public String removeInstaLike(@RequestParam Integer likeId,@RequestParam String email,@RequestParam String token){
        if(authenticationService.authenticate(email,token)){
            return userService.removeInstaLike(likeId,email);
        }
        else{
            return "Not an Authenticated user activity!!!";
        }
    }

    //follow functionalities
    @PostMapping("follow")
    public String followUser(@RequestBody Follow follow,@RequestParam String followerEmail,@RequestParam String token){
        if(authenticationService.authenticate(followerEmail,token)){
            return userService.followUser(follow,followerEmail);
        }
        else{
            return "Not an Authenticated user activity!!!";
        }
    }

    @DeleteMapping("unfollow/target/{followId}")
    public String unFollowUser(@PathVariable Integer followId, @RequestParam String followerEmail, @RequestParam String followerToken)
    {
        if(authenticationService.authenticate(followerEmail,followerToken)) {
            return userService.unFollowUser(followId,followerEmail);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }





}
