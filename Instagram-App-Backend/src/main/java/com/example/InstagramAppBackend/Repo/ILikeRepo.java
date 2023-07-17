package com.example.InstagramAppBackend.Repo;

import com.example.InstagramAppBackend.Model.AuthenticationToken;
import com.example.InstagramAppBackend.Model.Like;
import com.example.InstagramAppBackend.Model.Post;
import com.example.InstagramAppBackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILikeRepo extends JpaRepository<Like,Integer> {
    List<Like> findByInstaPostAndLiker(Post post, User liker);

    List<Like> findByInstaPost(Post post);
}
