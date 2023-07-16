package com.example.MappingPractice.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity@AllArgsConstructor@NoArgsConstructor@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    private String title;
    private String description;
    private String duration;

    @ManyToMany
    @JoinTable(name="student_courses",joinColumns = @JoinColumn(name = "fk_course-id"),inverseJoinColumns = @JoinColumn(name = "fk_student_id"))
    List<Student> studentList;
}
