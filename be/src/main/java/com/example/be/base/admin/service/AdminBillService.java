package com.example.be.base.admin.service;

import com.example.be.base.admin.model.response.AdminBillResponse;
import com.example.be.base.admin.repository.AdminBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminBillService {

    @Autowired
    private AdminBillRepository repository;

    public List<AdminBillResponse> getAll() {
        return repository.getAll();
    }

}
