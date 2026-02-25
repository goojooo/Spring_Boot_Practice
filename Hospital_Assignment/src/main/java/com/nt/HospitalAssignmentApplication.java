package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.controller.HospitalController;
import com.nt.model.Hospital;

@SpringBootApplication
public class HospitalAssignmentApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Lccation 1::");
		String loc1 = sc.next();

		System.out.println("Enter Location 2::");
		String loc2 = sc.next();

		System.out.println("Enter Location 3::");
		String loc3 = sc.next();

		ApplicationContext ctx = SpringApplication.run(HospitalAssignmentApplication.class, args);
		HospitalController controller = ctx.getBean("hosController", HospitalController.class);

		try {
			List<Hospital> list = controller.processHospitalByLoc(loc1, loc2, loc3);
			for (Hospital hos : list) {

				System.out.println(hos);

			}
		} // try
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
