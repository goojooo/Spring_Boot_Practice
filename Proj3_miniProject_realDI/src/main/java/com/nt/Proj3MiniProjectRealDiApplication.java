package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.controller.EmployeeOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class Proj3MiniProjectRealDiApplication {

	public static void main(String[] args) {
		   //read the desgs from the enduser
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Desg1::");
        String desg1=sc.next();
        System.out.println("Enter Desg2::");
        String desg2=sc.next();
        System.out.println("Enter Desg3::");
        String desg3=sc.next();
        ApplicationContext ctx= SpringApplication.run(Proj3MiniProjectRealDiApplication.class, args);
		
		 // get Controller class obj ref
        EmployeeOperationsController controller=ctx.getBean("empController",EmployeeOperationsController.class);
        
        try {
            List<Employee> list=controller.processEmployeeByDesgs(desg1, desg2, desg3);
            for (Employee emp : list) {

          System.out.println(emp);
                 
            }
        }//try
        catch(Exception e) {
            e.printStackTrace();
        }

	}

}
