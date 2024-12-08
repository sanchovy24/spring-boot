package com.ryazanova.MyApplicationH2.controller;

import com.ryazanova.MyApplicationH2.entity.Student;
import com.ryazanova.MyApplicationH2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> showAllStudents() {
        List<Student> allStudents = studentService.getAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") int id) {
        Student student = studentService.getStudent(id);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/students")
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        // Проверка на корректность входных данных
        if (student == null || student.getName() == null || student.getName().isEmpty()) {
            return new ResponseEntity<>("Invalid student data", HttpStatus.BAD_REQUEST);
        }

        Student savedStudent = studentService.saveStudent(student);
        if (savedStudent != null) {
            return new ResponseEntity<>("Student saved successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to save student", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/students")
    public ResponseEntity<String> updateStudent(@RequestBody Student student) {
        // Проверка на корректность входных данных
        if (student == null || student.getId() <= 0 || student.getName() == null || student.getName().isEmpty()) {
            return new ResponseEntity<>("Invalid student data", HttpStatus.BAD_REQUEST);
        }

        Student updatedStudent = studentService.saveStudent(student);
        if (updatedStudent != null) {
            return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update student", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) {
        // Проверка на корректность входных данных
        if (id <= 0) {
            return new ResponseEntity<>("Invalid student ID", HttpStatus.BAD_REQUEST);
        }

        if (studentService.getStudent(id) != null) {
            studentService.deleteStudent(id);
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }
}