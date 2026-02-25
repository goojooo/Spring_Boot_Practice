package com.nt.dao;

import java.util.List;

import com.nt.model.Hospital;

public interface IHospitalDAO {

	public List<Hospital> showHospitalByLoc(String loc1,String loc2,String loc3)throws Exception;
}
