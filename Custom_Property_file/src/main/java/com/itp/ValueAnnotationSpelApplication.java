package com.itp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.itp.bean.Student;

@SpringBootApplication
@PropertySource("com/itp/commons/info.properties")
public class ValueAnnotationSpelApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ValueAnnotationSpelApplication.class, args);

		// get Spring Bean class obj ref
		Student stud = ctx.getBean("stud", Student.class);
		System.out.println(stud);
		// MarksInfo m1=ctx.getBean("marks",MarksInfo.class);
		// System.out.println(m1);
	}

}
