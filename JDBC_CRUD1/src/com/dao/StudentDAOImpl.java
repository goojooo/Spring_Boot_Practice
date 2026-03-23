package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.model.Student;
import com.util.DBConnection;

public class StudentDAOImpl implements StudentDAO {
	Connection con = DBConnection.getConnection();
	PreparedStatement psInsert;
	@Override
	public void addStudent(Student student) {
		String sql = "insert into student (name, email) values (?,?)";
		
		
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		
	}

}
