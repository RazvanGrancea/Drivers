package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public class StudentControllerTest {

  private StudentController controllerTest;

  @BeforeEach
  public void setUp() {
    final StudentService mockStudent = Mockito.mock(StudentService.class);
    Mockito.when(mockStudent.getStudentById(1L))
        .thenReturn(Optional.of(Student.builder().name("test").build()));

    controllerTest = new StudentController(mockStudent);
  }
}
