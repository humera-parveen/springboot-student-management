package com.student.controller;

import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;
import com.student.serviceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServiceImpl studentService;

    @PostMapping("/save")
    public ResponseEntity<StudentResponse> saveAll(@RequestBody StudentRequest studentRequest) {
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
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        StudentResponse student = studentService.getById(id);
        if (student == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("message : ", "Student ID is not present");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hashMap);
        }
        return ResponseEntity.ok(student);

    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> updateById(@RequestBody StudentRequest studentRequest, @PathVariable("id") int id) {
        StudentResponse updateStudent = studentService.updateStudent(id, studentRequest);
        if (updateStudent == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        studentService.delete(id);
        return ResponseEntity.ok().body("Student ID deleted successfully");
    }

}
