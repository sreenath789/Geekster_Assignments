package com.example.InstagramAppBackend.Controller;

import com.example.InstagramAppBackend.Model.Post;
import com.example.InstagramAppBackend.Model.User;
import com.example.InstagramAppBackend.Model.dto.SignInInput;
import com.example.InstagramAppBackend.Model.dto.SignUpOutput;
import com.example.InstagramAppBackend.Service.AuthenticationService;
import com.example.InstagramAppBackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("user/signup")
    public SignUpOutput signUpInstaUser(@RequestBody User user)
    {
        return userService.signUpUser(user);
    }

    @PostMapping("user/signin")
    public String signInInstaUser(@RequestBody SignInInput signInInput)
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

    @GetMapping("posts")
    public List<Post> getAllPosts(@RequestParam String email){
        return userService.getAllPosts(email);
    }




}
