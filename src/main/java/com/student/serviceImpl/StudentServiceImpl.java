package com.student.serviceImpl;

import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;
import com.student.entity.Student;
import com.student.mapper.StudentMapper;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<StudentResponse> getAll() {
        List<Student> students = studentRepo.findAll();
        return studentMapper.mapToAll(students);
    }

    @Override
    public StudentResponse getById(int studentId) {
        Optional<Student> student = studentRepo.findById(studentId);

        if (student.isPresent()) {
            return studentMapper.mapToResponse(student.get());
        }
        return null;

    }

    @Override
    public StudentResponse updateStudent(int studentId, StudentRequest studentRequest) {
        Optional<Student> student = studentRepo.findById(studentId);
        if (student.isEmpty()) {

            return null;
        }
        Student existingData = student.get();
        studentMapper.updateEntity(studentRequest, existingData);
        Student updateData = studentRepo.save(existingData);
        return studentMapper.mapToResponse(updateData);
    }
    @Override
    public void delete(int studentId) {
        if (studentRepo.existsById(studentId)) {
            studentRepo.deleteById(studentId);
        } else {
            throw new RuntimeException("Student Id is not Exist");
        }
    }

}
