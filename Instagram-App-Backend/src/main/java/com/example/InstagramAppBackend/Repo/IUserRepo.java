package com.example.InstagramAppBackend.Repo;

import com.example.InstagramAppBackend.Model.AuthenticationToken;
import com.example.InstagramAppBackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User,Integer> {
    User findFirstByUserEmail(String signInEmail);

    User findByUserId(Integer id);
}
