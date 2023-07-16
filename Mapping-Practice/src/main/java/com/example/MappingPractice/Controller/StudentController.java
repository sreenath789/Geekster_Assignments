package com.example.MappingPractice.Controller;

import com.example.MappingPractice.Model.Student;
import com.example.MappingPractice.Service.AddressService;
import com.example.MappingPractice.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("student")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @GetMapping("students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PutMapping("student/{id}/dept/{department}")
    public String updateStudent(@PathVariable Integer id,@PathVariable String department){
        return studentService.updateStudent(id,department);
    }

    @DeleteMapping("student/{id}")
    public String deleteStudent(@PathVariable Integer id){
       return studentService.deleteStudent(id);
    }
}
