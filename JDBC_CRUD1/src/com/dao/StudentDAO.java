package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Student;

public interface StudentDAO {
	void addStudent(Student student) throws SQLException;
	Student getStudentById(int id);
	List<Student> getAllStudents();
	void updateStudent(Student student);
	void deleteStudent(int id);
}
