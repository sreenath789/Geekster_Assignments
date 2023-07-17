package com.example.InstagramAppBackend.Service;

import com.example.InstagramAppBackend.Model.Comment;
import com.example.InstagramAppBackend.Repo.ICommentRepo;
import com.example.InstagramAppBackend.Repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {

    @Autowired
    ICommentRepo iCommentRepo;

    public String addComment(Comment comment) {
        comment.setCommentCreationTimeStamp(LocalDateTime.now());
        iCommentRepo.save(comment);
        return "Comment added";
    }

    public Comment findComment(Integer commentId) {
        return iCommentRepo.findById(commentId).orElse(null);
    }

    public void removeInstaComment(Comment comment) {
        iCommentRepo.delete(comment);
    }
}
