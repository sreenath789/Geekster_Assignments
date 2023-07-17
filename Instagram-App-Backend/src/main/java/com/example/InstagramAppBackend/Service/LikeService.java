package com.example.InstagramAppBackend.Service;

import com.example.InstagramAppBackend.Model.Like;
import com.example.InstagramAppBackend.Model.Post;
import com.example.InstagramAppBackend.Model.User;
import com.example.InstagramAppBackend.Repo.ILikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    ILikeRepo iLikeRepo;

    public boolean isLikeAllowedOnThisPost(Post post, User liker) {
        List<Like> likeList = iLikeRepo.findByInstaPostAndLiker(post,liker);
        return likeList!=null && likeList.isEmpty();
    }

    public void addLike(Like like) {
        iLikeRepo.save(like);
    }



    public Integer getLikeCountForPost(Post post) {
        return iLikeRepo.findByInstaPost(post).size();
    }

    public Like getLikeById(Integer likeId) {
        return iLikeRepo.findById(likeId).orElse(null);
    }

    public void removeLike(Like like) {
        iLikeRepo.delete(like);
    }
}
