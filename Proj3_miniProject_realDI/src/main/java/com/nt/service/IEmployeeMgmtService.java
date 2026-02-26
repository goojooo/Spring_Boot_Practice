package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
	public List<Employee> fetchEmployeesByDesgs(String desg1,String desg2,String desg3)throws Exception;
    public int registerEmployee(Employee emp) throws Exception;
    public int removeEmployeeByNo(int eno) throws Exception;
}
