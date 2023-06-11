package com.example.be.base.admin.service;

import com.example.be.base.admin.repository.AdminVoucherRepository;
import com.example.be.base.user.model.response.UserVoucherResponse;
import com.example.be.entity.Bill;
import com.example.be.entity.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminVoucherService {

    @Autowired
    private AdminVoucherRepository repository;

    public List<Voucher> getAll() {
        return repository.findAll();
    }

    public Voucher getVoucherResponseByBill(Bill bill) {
        return repository.findVoucherByBill(bill);
    }

}
