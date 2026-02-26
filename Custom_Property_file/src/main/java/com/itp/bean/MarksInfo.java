package com.itp.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("marks")
public class MarksInfo {

	@Value("${stud.marks1}")
	private Integer m1;
	@Value("${stud.marks2}")
	private Integer m2;
	@Value("${stud.marks3}")
	private Integer m3;

	public Integer getM1() {
		return m1;
	}

	public void setM1(Integer m1) {
		this.m1 = m1;
	}

	public Integer getM2() {
		return m2;
	}

	public void setM2(Integer m2) {
		this.m2 = m2;
	}

	public Integer getM3() {
		return m3;
	}

	public void setM3(Integer m3) {
		this.m3 = m3;
	}

	@Override
	public String toString() {
		return "MarksInfo [m1=" + m1 + ", m2=" + m2 + ", m3=" + m3 + "]";
	}

}
