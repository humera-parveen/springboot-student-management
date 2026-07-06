package com.student.controller;

import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;
import com.student.serviceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
