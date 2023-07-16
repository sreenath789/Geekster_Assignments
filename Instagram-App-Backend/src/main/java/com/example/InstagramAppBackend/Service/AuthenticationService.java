package com.example.InstagramAppBackend.Service;

import com.example.InstagramAppBackend.Model.AuthenticationToken;
import com.example.InstagramAppBackend.Model.User;
import com.example.InstagramAppBackend.Repo.IAuthenticationRepo;
import com.example.InstagramAppBackend.Repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthenticationRepo iAuthenticationRepo;

    public boolean authenticate(String email,String token){
        AuthenticationToken authenticationToken = iAuthenticationRepo.findFirstByTokenValue(token);
        if(authenticationToken == null){
            return false;
        }
        String tokenConnectedMail = authenticationToken.getUser().getUserEmail();
        return tokenConnectedMail.equals(email);
    }

    public void saveToken(AuthenticationToken authenticationToken) {
        iAuthenticationRepo.save(authenticationToken);
    }

    public AuthenticationToken findFirstByUser(User user) {
        return iAuthenticationRepo.findFirstByUser(user);
    }

    public void remove(AuthenticationToken authenticationToken) {
        iAuthenticationRepo.delete(authenticationToken);
    }
}
