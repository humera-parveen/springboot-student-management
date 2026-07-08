package com.student.repository;

import com.student.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Page<Student> findByStudentName(String studentName, Pageable pageable);
    Page<Student> findByCollege(String college,Pageable pageable);
}
