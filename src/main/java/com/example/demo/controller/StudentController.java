package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

  private final StudentService studentService;

  @Autowired
  public StudentController(final StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  @Tag(name = "List")
  public ResponseEntity<List<Student>> getAllStudents() {

    List<Student> students = studentService.getAllStudents();
    return ResponseEntity.ok(students);
  }

  @GetMapping("/{id}")
  @Tag(name = "List")
  public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
    Optional<Student> studentOptional = studentService.getStudentById(id);
    return studentOptional
        .map(student -> ResponseEntity.ok(student))
        .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }

  @PostMapping
  @Tag(name = "Add")
  public ResponseEntity<Void> addStudent(@RequestBody Student student) {
    studentService.addStudent(student);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping("/{id}")
  @Tag(name = "Delete")
  public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
    if (studentService.getStudentById(id).isPresent()) {
      studentService.deleteStudent(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @DeleteMapping
  @Tag(name = "Delete")
  public ResponseEntity<Void> deleteAll() {
    studentService.deleteAll();
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
