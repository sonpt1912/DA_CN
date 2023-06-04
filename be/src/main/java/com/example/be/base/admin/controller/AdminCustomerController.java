package com.example.be.base.admin.controller;

import com.example.be.base.admin.model.response.AdminCustomerResponse;
import com.example.be.base.admin.service.AdminBillService;
import com.example.be.base.admin.service.AdminCustomerService;
import com.example.be.entity.Bill;
import com.example.be.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/customer")
@CrossOrigin(origins = {"*"})
public class AdminCustomerController {

    @Autowired
    private AdminCustomerService customerService;

    @Autowired
    private AdminBillService billService;

    @GetMapping("/get-all-customer")
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        Customer customer = customerService.getOneById(id);
        customer.setStatus(1);
        customerService.update(customer);
    }

    @GetMapping("/get-by-bill/{id}")
    public AdminCustomerResponse getByBill(@PathVariable("id") Long id) {
        Bill bill = billService.findOneById(id);
        return customerService.getOneByBill(bill);
    }

}
