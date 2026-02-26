package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {
	// create sql query
	private static final String GET_EMPS_BY_DESGS = "SELECT ENO,ENAME,DESG,SALARY FROM EMPLOYEE WHERE DESG IN(?,?,?) ORDER BY DESG";
	private static final String INSERT_EMP = "INSERT INTO EMPLOYEE(ENO,ENAME,DESG,SALARY) VALUES(?,?,?,?)";
	private static final String DELETE_EMP_BY_NO =
	        "DELETE FROM EMPLOYEE WHERE ENO=?";
	// has a .as a part of autoconfiguration ,we will get HikariDatSource as a
	// predefined springbean class
	@Autowired
	private DataSource ds;// inject HikariDataSource class as a dependent class

	@Override
	public List<Employee> showEmployessByDesgs(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> list = null;
		try ( // get Pooled jdbc con object
				Connection con = ds.getConnection();
				// create PreparedStatement object
				PreparedStatement ps = con.prepareStatement(GET_EMPS_BY_DESGS);) {
			// set values to Queyr params
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			// execute the Query
			try (ResultSet rs = ps.executeQuery()) {
				// copy ResultSET obj records to ArrayList Collection
				list = new ArrayList<Employee>();

				while (rs.next()) {
					Employee emp = new Employee(); // create emp class obj
					emp.setEno(rs.getInt(1)); // setting all values in emp class obj
					emp.setEnmae(rs.getString(2));
					emp.setDesg(rs.getString(3));
					emp.setSalary(rs.getFloat(4));
					list.add(emp);// adding emp obj into list collection
				} // while
			} // try2
		} // try1
		catch (SQLException se) {
			throw se; // Exception Rethrowing
		} catch (Exception e) {
			throw e;
		}
		return list;
	}

	@Override
	public int insertEmployee(Employee emp) throws Exception {
		int result = 0;

		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(INSERT_EMP);) {
			// Set values
			ps.setInt(1, emp.getEno());
			ps.setString(2, emp.getEnmae());
			ps.setString(3, emp.getDesg());
			ps.setFloat(4, emp.getSalary());

			// Execute Query (for INSERT/UPDATE/DELETE use executeUpdate)
			result = ps.executeUpdate();

		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			throw e;
		}

		return result;
	}

	@Override
	public int deleteEmployeeByNo(int eno) throws Exception {

	    int result = 0;

	    try(
	        Connection con = ds.getConnection();
	        PreparedStatement ps = con.prepareStatement(DELETE_EMP_BY_NO);
	    ){

	        ps.setInt(1, eno);

	        result = ps.executeUpdate();  // returns no. of rows deleted
	    }
	    catch(Exception e) {
	        throw e;
	    }

	    return result;
	}
}
