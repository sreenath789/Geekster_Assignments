package com.example.MappingPractice.Service;

import com.example.MappingPractice.Model.Student;
import com.example.MappingPractice.Repo.IAddressRepo;
import com.example.MappingPractice.Repo.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    IStudentRepo iStudentRepo;

    public void addStudent(Student student) {
        iStudentRepo.save(student);
    }

    public List<Student> getAllStudents() {
        return iStudentRepo.findAll();
    }


    public String updateStudent(Integer id, String department) {
        if (iStudentRepo.existsById(id)){
            Student student = iStudentRepo.findById(id).get();
            student.setDepartment(department);
            iStudentRepo.save(student);
            return "Student updated";
        }
        return "student not found";
    }

    public String deleteStudent(Integer id) {
        if (iStudentRepo.existsById(id)){
            iStudentRepo.deleteById(id);
            return "Student Deleted";
        }
        return "student not found";
    }
}
