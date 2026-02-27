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

		ApplicationContext ctx = SpringApplication.run(Proj3MiniProjectRealDiApplication.class, args);

		EmployeeOperationsController controller = ctx.getBean("empController", EmployeeOperationsController.class);

		Scanner sc = new Scanner(System.in);

		System.out.println("1. Show Employees By Designation");
		System.out.println("2. Insert New Employee");
		System.out.println("3. Delete Employee By Number");
		System.out.println("Choose Option:");
		int choice = sc.nextInt();

		try {

			if (choice == 1) {

				System.out.println("Enter Desg1::");
				String desg1 = sc.next();

				System.out.println("Enter Desg2::");
				String desg2 = sc.next();

				System.out.println("Enter Desg3::");
				String desg3 = sc.next();

				List<Employee> list = controller.processEmployeeByDesgs(desg1, desg2, desg3);

				list.forEach(System.out::println);
			}

			else if (choice == 2) {

				Employee emp = new Employee();

				System.out.println("Enter Employee No:");
				emp.setEno(sc.nextInt());

				System.out.println("Enter Employee Name:");
				emp.setEnmae(sc.next());

				System.out.println("Enter Employee Designation:");
				emp.setDesg(sc.next());

				System.out.println("Enter Employee Salary:");
				emp.setSalary(sc.nextFloat());

				String result = controller.registerEmployee(emp);
				System.out.println(result);
			} else if (choice == 3) {

				System.out.println("Enter Employee Number to Delete:");
				int eno = sc.nextInt();

				String result = controller.deleteEmployee(eno);
				System.out.println(result);
			}

			else {
				System.out.println("Invalid Choice");
				System.out.println("Please enter valid choice...");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		sc.close();
	}
}