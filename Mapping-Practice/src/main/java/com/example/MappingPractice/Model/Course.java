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
    private Integer ID;
    private String title;
    private String description;
    private String duration;

    @ManyToMany
    List<Student> studentList;
}
