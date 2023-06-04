package com.example.be.base.admin.service;

import com.example.be.base.admin.model.response.AdminCustomerResponse;
import com.example.be.base.admin.repository.AdminCustomerRepository;
import com.example.be.entity.Bill;
import com.example.be.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminCustomerService {

    @Autowired
    private AdminCustomerRepository repository;

    public List<Customer> getAll() {
        return repository.findAll();
    }

    public Customer getOneById(Long id) {
        return repository.findCustomerById(id);
    }

    public void update(Customer customer) {
        repository.save(customer);
    }

    public AdminCustomerResponse getOneByBill(Bill bill) {
        return repository.getOneByBill(bill);
    }

}
