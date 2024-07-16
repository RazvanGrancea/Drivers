package com.example.demo.Service;
import com.example.demo.StudentModel.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();
    public StudentService(){
        students.add(new Student(1L, "Tudor", 9.80));
        students.add(new Student(2L, "Visan", 9.60));
        students.add(new Student(3L, "Grancea", 9.45));
        students.add(new Student(4L, "Mihaescu", 9.10));

    }


    public List<Student> getAllStudents() {
        return students;
    }

    }


