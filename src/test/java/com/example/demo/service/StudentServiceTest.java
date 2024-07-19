package com.example.demo.service;


import com.example.demo.model.Student;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class StudentServiceTest {

    private StudentService studentService;


    @BeforeEach
    public void setup() {
        studentService = new StudentService();
    }

    @Test
    public void test_addStudent_success() {
        // Given
        final Student expected = Student.builder()
                .id(1L)
                .name("Sorin")
                .grade(Double.parseDouble("9.30"))
                .build();

        // When
        final Student actual = studentService.addStudent(expected);

        //Then
        assertThat(actual, equalTo(expected));

        final Optional<Student> retrieve = studentService.getStudentById(expected.getId());
        assertThat(retrieve.isPresent(), equalTo(true));
        assertThat(retrieve.get(), equalTo(expected));
    }

    @Test
    public void test_deleteStudent_success() {

    }


}
