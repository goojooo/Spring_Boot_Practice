package com.localservice.service;

import com.localservice.model.ServicePartnerRequest;
import com.localservice.repository.ServicePartnerRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePartnerService {

    @Autowired
    private ServicePartnerRequestRepository requestRepo;

    public void submitRequest(ServicePartnerRequest request){

        request.setStatus("PENDING");
        requestRepo.save(request);

    }
}