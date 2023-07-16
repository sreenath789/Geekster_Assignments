package com.example.InstagramAppBackend.Service;

import com.example.InstagramAppBackend.Repo.ICommentRepo;
import com.example.InstagramAppBackend.Repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    ICommentRepo iCommentRepo;
}
