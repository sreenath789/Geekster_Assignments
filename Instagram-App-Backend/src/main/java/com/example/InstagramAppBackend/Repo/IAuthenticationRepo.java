package com.example.InstagramAppBackend.Repo;

import com.example.InstagramAppBackend.Model.Admin;
import com.example.InstagramAppBackend.Model.AuthenticationToken;
import com.example.InstagramAppBackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken,Integer> {
    AuthenticationToken findFirstByTokenValue(String token);

    AuthenticationToken findFirstByUser(User user);
}
