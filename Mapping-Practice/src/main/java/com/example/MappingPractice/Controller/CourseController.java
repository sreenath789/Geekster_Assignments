package com.example.MappingPractice.Controller;

import com.example.MappingPractice.Model.Course;
import com.example.MappingPractice.Service.AddressService;
import com.example.MappingPractice.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("course")
    public void addCourse(@RequestBody Course course){
         courseService.addCourse(course);
    }

    @GetMapping("courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }


    @PutMapping("course/{id}/title/{title}")
    public String updateCourse(@PathVariable Integer id,@PathVariable String title){
        return courseService.updateCourse(id,title);
    }

    @DeleteMapping("course/{id}")
    public String deleteCourse(@PathVariable Integer id){
        return  courseService.deleteCourse(id);
    }
}
