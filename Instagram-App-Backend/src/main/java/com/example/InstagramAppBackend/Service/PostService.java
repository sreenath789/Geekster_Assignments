package com.example.InstagramAppBackend.Service;

import com.example.InstagramAppBackend.Model.Post;
import com.example.InstagramAppBackend.Model.User;
import com.example.InstagramAppBackend.Repo.IPostRepo;
import com.example.InstagramAppBackend.Repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    @Autowired
    IPostRepo iPostRepo;

    public String createInstaPost(Post post) {
        post.setPostCreatedTimeStamp(LocalDateTime.now());
        iPostRepo.save(post);
        return "Post Uploaded!";
    }

    public List<Post> getAllPosts(User postOwner) {
        return iPostRepo.findAllByPostOwner(postOwner);
    }
}
