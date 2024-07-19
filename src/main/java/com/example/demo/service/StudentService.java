package com.example.demo.service;

import com.example.demo.model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
  private final List<Student> students = new ArrayList<>();

  public List<Student> getAllStudents() {
    return students;
  }

  public Optional<Student> getStudentById(Long id) {
    for (Student student : students) {
      if (student.getId().equals(id)) {
        return Optional.of(student);
      }
    }

    return Optional.empty();
  }

  public Student addStudent(Student student) {
    students.add(student);
    return student;
  }

  public Optional<Student> deleteStudent(Long id) {
    Optional<Student> studentOpt = getStudentById(id);
    studentOpt.ifPresent(students::remove);
    return studentOpt;
  }

  public void deleteAll() {
    students.clear();
  }
}
