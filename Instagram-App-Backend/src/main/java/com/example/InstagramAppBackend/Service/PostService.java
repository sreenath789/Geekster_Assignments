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

    public String removeInstaPost(Integer postId, User user) {
        Post post = iPostRepo.findById(postId).orElse(null);
        if(post!=null && post.getPostOwner().equals(user)){
            iPostRepo.delete(post);
            return "Post removed successfully!";
        }
        else if(post==null){
            return "Post to be deleted does not exist";
        }
        else{
            return "Un-Authorized delete detected....Not allowed";
        }
    }

    public boolean validatePost(Post instaPost) {
        return (instaPost!=null && iPostRepo.existsById(instaPost.getPostId()));
    }

    public Post getPostById(Integer postId) {
        return iPostRepo.findById(postId).orElse(null);
    }
}
