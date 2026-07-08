package com.student.serviceImpl;

import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;
import com.student.entity.Student;
import com.student.exception.StudentNotFoundException;
import com.student.mapper.StudentMapper;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public StudentResponse getById(int studentId) throws StudentNotFoundException {
        Optional<Student> student = studentRepo.findById(studentId);

        if (student.isPresent()) {
            return studentMapper.mapToResponse(student.get());
        } else {
            throw new StudentNotFoundException("Student Not Found With This ID : " + studentId);
        }

    }

    @Override
    public StudentResponse updateStudent(int studentId, StudentRequest studentRequest) throws StudentNotFoundException {
        Optional<Student> student = studentRepo.findById(studentId);
        if (!student.isEmpty()) {
            Student existingData = student.get();
            studentMapper.updateEntity(studentRequest, existingData);
            Student updateData = studentRepo.save(existingData);
            return studentMapper.mapToResponse(updateData);
        } else {
            throw new StudentNotFoundException("Student Not Found With This ID : " + studentId);
        }
    }

    @Override
    public void delete(int studentId) throws StudentNotFoundException {
        if (studentRepo.existsById(studentId)) {
            studentRepo.deleteById(studentId);
        } else {
            throw new StudentNotFoundException("Student Not Found With This ID : " + studentId);
        }
    }


    @Override
    public Page<StudentResponse> getAllStudent(int page, int size, String sortBy, String direction, String search) {
        Sort sort = null;
        if (direction.equalsIgnoreCase("ASC")) {
            sort = Sort.by(sortBy).ascending();
        } else {
            sort = Sort.by(sortBy).descending();
        }

        Pageable pageable = PageRequest.of(page, size, sort);
        if (search == null) {
            Page<Student> studentPage = studentRepo.findAll(pageable);
            return studentPage.map(studentMapper::mapToResponse);
        } else {
            //   Page<Student> byName = studentRepo.findByStudentName(search, pageable);
            //    return byName.map(studentMapper::mapToResponse);
            Page<Student> byCollegeName = studentRepo.findByCollege(search, pageable);
            return byCollegeName.map(studentMapper::mapToResponse);

        }
    }

}


