package com.example.InstagramAppBackend.Repo;

import com.example.InstagramAppBackend.Model.AuthenticationToken;
import com.example.InstagramAppBackend.Model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikeRepo extends JpaRepository<Like,Integer> {
}
