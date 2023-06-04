package com.example.be.base.user.service;

import com.example.be.base.user.model.response.UserVoucherResponse;
import com.example.be.base.user.repository.UserVoucherRepository;
import com.example.be.entity.Bill;
import com.example.be.entity.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserVoucherService {

    @Autowired
    private UserVoucherRepository repository;

    public UserVoucherResponse getVoucherResponseByCode(String code) {
        return repository.getByCode(code);
    }

    public Voucher getByCode(String code) {
        return repository.findVoucherByCode(code);
    }

    public UserVoucherResponse getVoucherResponseByBill(Bill bill) {
        return repository.getByBill(bill);
    }
}
