package com.nt.model;

public class Employee {

    private Integer eno;
    private String enmae;
    private String desg;
    private Float salary;
    private Float grossSalary;
    private Float netSalary;
    
	public Integer getEno() {
		return eno;
	}
	public void setEno(Integer eno) {
		this.eno = eno;
	}
	public String getEnmae() {
		return enmae;
	}
	public void setEnmae(String enmae) {
		this.enmae = enmae;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public Float getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(Float grossSalary) {
		this.grossSalary = grossSalary;
	}
	public Float getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(Float netSalary) {
		this.netSalary = netSalary;
	}
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", enmae=" + enmae + ", desg=" + desg + ", salary=" + salary + ", grossSalary="
				+ grossSalary + ", netSalary=" + netSalary + "]";
	}

    
    
    
}
