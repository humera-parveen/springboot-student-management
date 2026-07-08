package com.student.service;

import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;
import com.student.entity.Student;
import com.student.exception.StudentNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    StudentResponse saveStudent(StudentRequest studentRequest);

   List<StudentResponse> getAll();

   StudentResponse getById(int studentId) throws StudentNotFoundException;

   StudentResponse updateStudent(int studentId, StudentRequest studentRequest) throws StudentNotFoundException;

    void delete(int studentId) throws StudentNotFoundException;

    public Page<StudentResponse> getAllStudent(int page, int size, String sortBy,String direction,String search);



}
