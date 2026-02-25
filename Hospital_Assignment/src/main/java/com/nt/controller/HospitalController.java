package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Hospital;
import com.nt.service.IHospitalMgmtService;

@Controller("hosController")
public class HospitalController {

    @Autowired
    private IHospitalMgmtService hosService;
    public List<Hospital> processHospitalByLoc(String loc1,String loc2,String loc3)throws Exception{
        //use service
        List<Hospital> list=hosService.fetchHospitalByLoc(loc1, loc2, loc3);
        return list;
    }
}
