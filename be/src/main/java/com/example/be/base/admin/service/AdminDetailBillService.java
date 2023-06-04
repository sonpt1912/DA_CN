package com.example.be.base.admin.service;

import com.example.be.base.admin.model.response.AdminDetailBillResponse;
import com.example.be.base.admin.repository.AdminDetailBillReposiotry;
import com.example.be.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminDetailBillService {

    @Autowired
    private AdminDetailBillReposiotry reposiotry;

    public List<AdminDetailBillResponse> getDetailBillByBill(Bill bill) {
        return reposiotry.getAllDetailBillByBill(bill);
    }
}
