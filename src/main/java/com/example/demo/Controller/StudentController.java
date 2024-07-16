package com.example.demo.Controller;
import com.example.demo.Service.StudentService;
import com.example.demo.StudentModel.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

      @Autowired
    private StudentService studentService;

      @GetMapping
    public List<Student> getAllStudents() {

          return studentService.getAllStudents();
    }

}