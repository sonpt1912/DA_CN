package com.example.be.base.user.service;

import com.example.be.base.user.model.response.UserAddressResponse;
import com.example.be.base.user.repository.UserAddressRepository;
import com.example.be.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressService {

    @Autowired
    private UserAddressRepository repository;

    public List<UserAddressResponse> getAddressByCustomer(Customer customer) {
        return repository.getAllByCustomer(customer);
    }

}
