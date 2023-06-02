package com.example.be.base.user.service;

import com.example.be.base.user.model.response.UserDetailBillResponse;
import com.example.be.base.user.repository.UserDetailBillRepository;
import com.example.be.entity.Bill;
import com.example.be.entity.DetailBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailBillService {

    @Autowired
    private UserDetailBillRepository repository;

    public void addListDetailBill(List<DetailBill> detailBills) {
        repository.saveAll(detailBills);
    }


    public List<UserDetailBillResponse> getListDetailBillByBill(Bill bill) {
        return repository.getAllDetailBillByBill(bill);
    }

}
