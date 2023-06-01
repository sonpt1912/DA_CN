package com.example.be.base.user.service;

import com.example.be.base.user.model.response.UserCustomerResponse;
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

    public UserCustomerResponse getCustomerResponseById(long id) {
        return repository.getOneResponseById(id);
    }

    public void update(Customer customer) {
        repository.save(customer);
    }

    public Customer getOneById(Long id) {
        return repository.findCustomerById(id);
    }
}
