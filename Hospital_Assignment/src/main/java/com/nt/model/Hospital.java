package com.nt.model;

public class Hospital {

	private Integer hno;
	private String nnmae;
	private String type;
	private String speciality;
	private String location;
	
	public Integer getHno() {
		return hno;
	}
	public void setHno(Integer hno) {
		this.hno = hno;
	}
	public String getNnmae() {
		return nnmae;
	}
	public void setNnmae(String nnmae) {
		this.nnmae = nnmae;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Hospital [hno=" + hno + ", nnmae=" + nnmae + ", type=" + type + ", speciality=" + speciality
				+ ", location=" + location + "]";
	}

	
	
}
