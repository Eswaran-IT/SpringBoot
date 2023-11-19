package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.student.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
