package com.example.MappingPractice.Service;

import com.example.MappingPractice.Repo.IAddressRepo;
import com.example.MappingPractice.Repo.ICourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    ICourseRepo iCourseRepo;
}
