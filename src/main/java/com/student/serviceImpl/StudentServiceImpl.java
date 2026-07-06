package com.student.serviceImpl;

import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;
import com.student.entity.Student;
import com.student.mapper.StudentMapper;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepo;
    @Autowired
    StudentMapper studentMapper;

    @Override
    public StudentResponse saveStudent(StudentRequest studentRequest) {

        Student savedStudent = studentMapper.mapToEntity(studentRequest);
        savedStudent = studentRepo.save(savedStudent);
        return studentMapper.mapToResponse(savedStudent);

    }
}
