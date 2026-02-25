package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IHospitalDAO;
import com.nt.model.Hospital;
@Service("hosService")
public class HospitalMgmtServiceImpl implements IHospitalMgmtService {

	  @Autowired
	    private IHospitalDAO hosDAO;
	@Override
	public List<Hospital> fetchHospitalByLoc(String loc1, String loc2, String loc3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("HospitalMgmtServiceImpl.fetchHospitalByLoc()");
		  List<Hospital> list=hosDAO.showHospitalByLoc(loc1, loc2, loc3);

		
		return list;
	}

}
