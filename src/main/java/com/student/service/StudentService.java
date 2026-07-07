package com.student.service;

import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse saveStudent(StudentRequest studentRequest);

   List<StudentResponse> getAll();

   StudentResponse getById(int studentId);

   StudentResponse updateStudent(int studentId, StudentRequest studentRequest);

    void delete(int studentId);
}
