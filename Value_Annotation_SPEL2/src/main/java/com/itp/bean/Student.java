package com.itp.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("stud")
public class Student {
	@Value("1001")
	private Integer sno;
	@Autowired
	private MarksInfo m;

	@Value("${stud.name}")
	private String sname;

	@Value("${stud.addrs}")
	private String addrs;

	@Value("${stud.age}")
	private Float age;

	@Value("{stud.collage}")
	private String collage;

	@Value("#{marks.m1 + marks.m2 + marks.m3}")
	private Float total;
	@Value("#{marks.m3 > 35.0}")
	private boolean isM3Passed;

	// injecting the values collected from the system properties
	@Value("${os.name}")
	private String os_name;
	@Value("${user.name}")
	private String user_name;

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", marks=" + m + ", sname=" + sname + ", addrs=" + addrs + ", age=" + age
				+ ", college=" + collage + ", total=" + total + ", isM3Passed=" + isM3Passed + ", os_name=" + os_name
				+ ", user_name=" + user_name + "]";
	}
}
