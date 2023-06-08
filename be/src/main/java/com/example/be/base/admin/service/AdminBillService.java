package com.example.be.base.admin.service;

import com.example.be.base.admin.model.response.AdminBillResponse;
import com.example.be.base.admin.model.response.AdminChartResponse;
import com.example.be.base.admin.repository.AdminBillRepository;
import com.example.be.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

@Service
public class AdminBillService {

    @Autowired
    private AdminBillRepository repository;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");

    private java.util.Date currentDate = new java.util.Date();

    public List<AdminBillResponse> getAll() {
        return repository.getAll();
    }

    public AdminBillResponse getOneByBill(Bill bill) {
        return repository.getOneByBill(bill);
    }

    public Bill findOneById(Long id) {
        return repository.findById(id).get();
    }

    public void updateStatus(Bill bill) {
        if (bill.getStatus() == 2) {
            bill.setDeliveryDate(java.sql.Date.valueOf(dateFormat.format(currentDate)));
        } else if (bill.getStatus() == 3) {
            bill.setReceivedDate(java.sql.Date.valueOf(dateFormat.format(currentDate)));
        }

        if (bill.getStatus() == 3 || bill.getPaymentDate() == null) {
            bill.setPaymentDate(java.sql.Date.valueOf(dateFormat.format(currentDate)));
        }
        repository.save(bill);
    }

    // staic
    public BigDecimal totalMoneyByThisMonth(Date startDate, Date endDate) {
        return repository.totalMoneyByThisMonth(startDate, endDate);
    }

    public BigDecimal totalMoneyByYear(Date startDate, Date endDate) {
        return repository.totalMoneyByYear(startDate, endDate);
    }

    public Long totalProduct(Date startDate, Date endDate) {
        return repository.totalProduct(startDate, endDate);
    }

    public List<AdminChartResponse> areaChart() {
        return repository.areaChart();
    }

}
