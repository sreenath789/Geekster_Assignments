package com.example.MappingPractice.Service;

import com.example.MappingPractice.Model.Course;
import com.example.MappingPractice.Repo.IAddressRepo;
import com.example.MappingPractice.Repo.ICourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    ICourseRepo iCourseRepo;

    public void addCourse(Course course) {
        iCourseRepo.save(course);
    }

    public List<Course> getAllCourses() {
        return iCourseRepo.findAll();
    }

    public String updateCourse(Integer id, String title) {
        if(iCourseRepo.existsById(id)){
            Course course = iCourseRepo.findById(id).get();
            course.setTitle(title);
            iCourseRepo.save(course);
            return "true";
        }
        return "false";
    }

    public String deleteCourse(Integer id) {
        if(iCourseRepo.existsById(id)){
            iCourseRepo.deleteById(id);
            return "true";
        }
        return "false";
    }
}
