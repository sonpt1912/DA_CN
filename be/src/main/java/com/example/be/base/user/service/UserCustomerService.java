package com.example.be.base.user.service;

import com.example.be.base.user.repository.UserCustomerRepository;
import com.example.be.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCustomerService {

    @Autowired
    private UserCustomerRepository repository;

    public Customer findCustomerById(long id) {
        return repository.findById(id).get();
    }

}
