package com.example.MappingPractice.Repo;

import com.example.MappingPractice.Model.Address;
import com.example.MappingPractice.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepo extends JpaRepository<Course,Integer> {
}
