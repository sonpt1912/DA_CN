package com.example.be.base.admin.controller;

import com.example.be.base.admin.model.response.AdminBillResponse;
import com.example.be.base.admin.service.AdminBillService;
import com.example.be.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/bill")
@CrossOrigin(origins = {"*"})
public class AdminBillController {

    @Autowired
    private AdminBillService service;

    @GetMapping("/get-all")
    public List<AdminBillResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/get-by-bill/{id}")
    public AdminBillResponse getOneById(@PathVariable("id") Long id) {
        Bill bill = service.findOneById(id);
        return service.getOneByBill(bill);
    }

    @PutMapping("/update-status-bill/{id}")
    public void updateStatus(@PathVariable("id") Long id, @RequestParam("status") int status) {
        Bill bill = service.findOneById(id);
        bill.setStatus(status + 1);
        service.updateStatus(bill);
    }

    @PutMapping("/cancel-status-bill/{id}")
    public void cancelStatus(@PathVariable("id") Long id) {
        Bill bill = service.findOneById(id);
        bill.setStatus(4);
        service.updateStatus(bill);
    }


}
