package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.model.Student;
import static com.util.DBConnection.getConnection;

public class StudentDAOImpl implements StudentDAO {
	private Connection con;
	private PreparedStatement psInsert, psUpdate, psDelete, psViewAll;

	public StudentDAOImpl() throws SQLException {
		con = getConnection();
		String sqlInsert = "insert into student (name, email) values (?,?)";
		psInsert = con.prepareStatement(sqlInsert);
	}

	@Override
	public void addStudent(Student student) throws SQLException {

		psInsert.setString(1, student.getName());
		psInsert.setString(2, student.getEmail());
		int i = psInsert.executeUpdate();
		if (i == 1) {

			System.out.println("Record inserted");
		} else {
			System.out.println("Record not inserted");
		}
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
