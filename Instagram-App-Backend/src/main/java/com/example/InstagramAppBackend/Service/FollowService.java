package com.example.InstagramAppBackend.Service;

import com.example.InstagramAppBackend.Model.Follow;
import com.example.InstagramAppBackend.Model.User;
import com.example.InstagramAppBackend.Repo.IFollowRepo;
import com.example.InstagramAppBackend.Repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {

    @Autowired
    IFollowRepo iFollowRepo;



    public boolean isFollowAllowed(User followTargetUser, User follower) {
        List<Follow> followList = iFollowRepo.findByCurrentUserAndCurrentUserFollower(followTargetUser,follower);
        return followList!=null && followList.isEmpty() && !followTargetUser.equals(follower);
    }

    public void startFollowing(Follow follow, User follower) {
        follow.setCurrentUserFollower(follower);
        iFollowRepo.save(follow);
    }

    public Follow findFollow(Integer followId) {
        return iFollowRepo.findById(followId).orElse(null);
    }

    public void unFollow(Follow follow) {
        iFollowRepo.delete(follow);
    }
}
