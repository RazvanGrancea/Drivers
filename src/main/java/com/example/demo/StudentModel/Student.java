package com.example.demo.StudentModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student{
    private Long id;
    private String name;
    private double grade;
}
