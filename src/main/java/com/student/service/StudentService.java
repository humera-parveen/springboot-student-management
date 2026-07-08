package com.student.service;

import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;
import com.student.exception.StudentNotFoundException;

import java.util.List;

public interface StudentService {
    StudentResponse saveStudent(StudentRequest studentRequest);

   List<StudentResponse> getAll();

   StudentResponse getById(int studentId) throws StudentNotFoundException;

   StudentResponse updateStudent(int studentId, StudentRequest studentRequest) throws StudentNotFoundException;

    void delete(int studentId) throws StudentNotFoundException;
}
