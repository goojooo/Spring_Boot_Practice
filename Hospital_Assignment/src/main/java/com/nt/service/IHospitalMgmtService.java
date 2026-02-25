package com.nt.service;

import java.util.List;

import com.nt.model.Hospital;

public interface IHospitalMgmtService {

    public List<Hospital> fetchHospitalByLoc(String loc1,String loc2,String loc3)throws Exception;
}
