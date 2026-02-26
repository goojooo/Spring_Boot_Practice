package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller("empController")
public class EmployeeOperationsController {

	@Autowired
	private IEmployeeMgmtService empService;

	public List<Employee> processEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception {

		return empService.fetchEmployeesByDesgs(desg1, desg2, desg3);
	}

	public String registerEmployee(Employee emp) throws Exception {

		int count = empService.registerEmployee(emp); // ✅ corrected

		return (count == 1) ? "Employee Inserted Successfully" : "Employee Not Inserted";
	}

	public String deleteEmployee(int eno) throws Exception {

		int count = empService.removeEmployeeByNo(eno);

		return (count == 1) ? "Employee Deleted Successfully" : "Employee Not Found";
	}
}