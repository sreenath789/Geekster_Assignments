package com.example.InstagramAppBackend.Repo;

import com.example.InstagramAppBackend.Model.Follow;
import com.example.InstagramAppBackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFollowRepo extends JpaRepository<Follow,Integer> {
    List<Follow> findByCurrentUserAndCurrentUserFollower(User currentFollower, User follower);
}
