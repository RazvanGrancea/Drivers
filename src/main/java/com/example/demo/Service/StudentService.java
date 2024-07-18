package com.example.demo.Service;

import com.example.demo.StudentModel.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();

    public StudentService() {
        students.add(new Student(1L, "Tudor", 9.80));
        students.add(new Student(2L, "Visan", 9.60));
        students.add(new Student(3L, "Grancea", 9.45));
        students.add(new Student(4L, "Mihaescu", 9.10));

    }


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

    public void addStudent(Student student) {
        students.add(student);

    }

    public void deleteStudent(Long id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    public void deleteAll() {
        students.clear();
    }
}


