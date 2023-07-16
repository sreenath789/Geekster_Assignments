package com.example.MappingPractice.Controller;

import com.example.MappingPractice.Service.AddressService;
import com.example.MappingPractice.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;
}
