package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.example.demo.repository.StudentRepo;
import com.example.demo.student.Student;

@RestController
class DBController {
    @Autowired
    StudentRepo repo;

    // 1. Create (POST)
    @PostMapping("/details")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = repo.save(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    // 2. Read (GET all)
    @GetMapping("/details")
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // 3. Read (GET by ID)
    @GetMapping("/details/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Optional<Student> optionalStudent = repo.findById(id);
        return optionalStudent.map(student -> new ResponseEntity<>(student, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // 4. Update (PUT)
    @PutMapping("/details/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        Optional<Student> optionalStudent = repo.findById(id);
        if (optionalStudent.isPresent()) {
            updatedStudent.setId(id);
            Student savedStudent = repo.save(updatedStudent);
            return new ResponseEntity<>(savedStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 5. Delete (DELETE)
    @DeleteMapping("/details/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        Optional<Student> optionalStudent = repo.findById(id);
        if (optionalStudent.isPresent()) {
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
