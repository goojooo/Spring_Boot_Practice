package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
    @Autowired
    private IEmployeeDAO empDAO;

    @Override
    public List<Employee> fetchEmployeesByDesgs(String desg1, String desg2, String desg3) throws Exception {
        System.out.println("EmployeeMgmtServiceImpl.fetchEmployeesByDesgs()");
        
        //use DAO REFERENCE TO CALL METHOD OF DAOIMPLEMENTATION CLASS
        List<Employee> list=empDAO.showEmployessByDesgs(desg1, desg2, desg3);
        // calculate grossSalary and netSalary of the employee
        for (Employee emp : list) {

            float salary = emp.getSalary();

            float gross = salary + (salary * 0.5f);   // +50%
            float net = gross - (gross * 0.2f);       // -20%
	 emp.setGrossSalary(gross);
            emp.setNetSalary(net);
             
        }
       return list;
    }
}

