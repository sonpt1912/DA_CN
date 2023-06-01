package com.example.be.base.user.service;

import com.example.be.base.user.model.response.UserBillResponse;
import com.example.be.base.user.repository.UserBillRepository;
import com.example.be.entity.Bill;
import com.example.be.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBillService {

    @Autowired
    private UserBillRepository repository;

    public List<UserBillResponse> getAllByCustomerAndStatus(Customer customer, int status) {
        return repository.getAllByCustomerAndStatus(customer, status);
    }

    public Bill addOrUpdate(Bill bill) {
        return repository.save(bill);
    }

}
