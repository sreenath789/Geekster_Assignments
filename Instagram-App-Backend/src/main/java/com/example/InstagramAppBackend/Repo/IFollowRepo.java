package com.example.InstagramAppBackend.Repo;

import com.example.InstagramAppBackend.Model.AuthenticationToken;
import com.example.InstagramAppBackend.Model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFollowRepo extends JpaRepository<Follow,Integer> {
}
