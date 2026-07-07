package com.student.mapper;

import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;
import com.student.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<StudentResponse> mapToAll(List<Student> student) {
        List<StudentResponse> studentList = new ArrayList<>();
        for (Student student1 : student) {
            StudentResponse studentResponse = mapToResponse(student1);
            studentList.add(studentResponse);
        }
        return studentList;
    }

    public void updateEntity(StudentRequest request, Student student) {
        student.setStudentName(request.getStudentName());
        student.setEmail(request.getEmail());
        student.setCollege(request.getCollege());
        student.setCourse(request.getCourse());
        student.setFees(request.getFees());

    }
}


