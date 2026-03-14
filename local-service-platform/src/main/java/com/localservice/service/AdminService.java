package com.localservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.localservice.model.ServicePartner;
import com.localservice.model.ServicePartnerRequest;
import com.localservice.repository.ServicePartnerRepository;
import com.localservice.repository.ServicePartnerRequestRepository;

@Service
public class AdminService {

    @Autowired
    private ServicePartnerRequestRepository requestRepo;

    @Autowired
    private ServicePartnerRepository partnerRepo;

    public void approvePartner(Long id){

    	ServicePartnerRequest req = requestRepo.findById(id).orElseThrow();

    	ServicePartner partner = new ServicePartner();

    	partner.setName(req.getName());
    	partner.setEmail(req.getEmail());
    	partner.setPhone(req.getPhone());
    	partner.setServiceType(req.getServiceType());
    	partner.setExperience(req.getExperience());

    	partnerRepo.save(partner);

    	requestRepo.deleteById(id);

    	}

    public void rejectPartner(Long id){

        requestRepo.deleteById(id);

    }
}