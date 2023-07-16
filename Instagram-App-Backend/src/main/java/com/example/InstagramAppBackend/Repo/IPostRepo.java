package com.example.InstagramAppBackend.Repo;

import com.example.InstagramAppBackend.Model.AuthenticationToken;
import com.example.InstagramAppBackend.Model.Post;
import com.example.InstagramAppBackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepo extends JpaRepository<Post,Integer> {
    List<Post> findAllByPostOwner(User postOwner);
}
