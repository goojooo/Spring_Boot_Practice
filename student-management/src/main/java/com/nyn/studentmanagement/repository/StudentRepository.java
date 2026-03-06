package com.nyn.studentmanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.nyn.studentmanagement.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
