package com.student.controller;

import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;
import com.student.exception.StudentNotFoundException;
import com.student.serviceImpl.StudentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServiceImpl studentService;

    @PostMapping("/save")
    public ResponseEntity<StudentResponse> saveAll(@RequestBody @Valid StudentRequest studentRequest) {
        StudentResponse studentResponse = studentService.saveStudent(studentRequest);
        return ResponseEntity.ok(studentResponse);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentResponse>> getAllStudent() {
        List<StudentResponse> studentList = studentService.getAll();
        if (studentList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) throws StudentNotFoundException {
        StudentResponse student = studentService.getById(id);
        return ResponseEntity.ok(student);

    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> updateById(@Valid @RequestBody StudentRequest studentRequest, @PathVariable("id") int id) throws StudentNotFoundException {
        StudentResponse updateStudent = studentService.updateStudent(id, studentRequest);
        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@Valid @PathVariable("id") int id) throws StudentNotFoundException {
        studentService.delete(id);
        return ResponseEntity.ok().body("Student ID deleted successfully");
    }

}
