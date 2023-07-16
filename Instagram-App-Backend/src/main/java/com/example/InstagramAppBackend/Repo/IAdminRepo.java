package com.example.InstagramAppBackend.Repo;

import com.example.InstagramAppBackend.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepo extends JpaRepository<Admin,Integer> {
}
