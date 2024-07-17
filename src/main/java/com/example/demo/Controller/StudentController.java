package com.example.demo.Controller;
import com.example.demo.Service.StudentService;
import com.example.demo.StudentModel.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    @PostMapping
    public void addStudent(@RequestBody Student student){
          studentService.addStudent(student);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
          studentService.deleteStudent(id);
    }
    @DeleteMapping
    public void deleteAll(){
          studentService.deleteAll();
    }

}