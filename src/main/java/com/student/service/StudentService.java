package com.student.service;

import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;
import com.student.entity.Student;

public interface StudentService {
    StudentResponse saveStudent(StudentRequest studentRequest);
}
