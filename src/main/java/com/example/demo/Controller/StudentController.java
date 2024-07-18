package com.example.demo.Controller;
import com.example.demo.Service.StudentService;
import com.example.demo.StudentModel.Student;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

      @Autowired
    private StudentService studentService;

      @GetMapping
      @Tag(name = "List" )
    public List<Student> getAllStudents() {

          return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    @Tag (name = "List")
    public Student getStudentById(@PathVariable Long id){
          return studentService.getStudentById(id);
    }
    @PostMapping @Tag(name = "Add")
    public void addStudent(@RequestBody Student student){
          studentService.addStudent(student);
    }
    @DeleteMapping("/{id}")  @Tag (name = "Delete")
    public void deleteStudent(@PathVariable Long id){
          studentService.deleteStudent(id);
    }
    @DeleteMapping  @Tag (name = "Delete")
    public void deleteAll(){
          studentService.deleteAll();
    }

}