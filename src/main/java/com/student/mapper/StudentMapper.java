package com.student.mapper;

import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;
import com.student.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public Student mapToEntity(StudentRequest studentRequest) {
        Student student = new Student();
        student.setStudentName(studentRequest.getStudentName());
        student.setEmail(studentRequest.getEmail());
        student.setCollege(studentRequest.getCollege());
        student.setCourse(studentRequest.getCourse());
        student.setFees(studentRequest.getFees());
        return student;
    }

    public StudentResponse mapToResponse(Student student) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setStudentId(student.getStudentId());
        studentResponse.setStudentName(student.getStudentName());
        studentResponse.setEmail(student.getEmail());
        studentResponse.setCollege(student.getCollege());
        studentResponse.setCourse(student.getCourse());
        studentResponse.setFees(student.getFees());
        return studentResponse;
    }
}
