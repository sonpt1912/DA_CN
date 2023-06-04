package com.example.be.base.admin.controller;

import com.example.be.base.admin.model.response.AdminDetailBillResponse;
import com.example.be.base.admin.service.AdminBillService;
import com.example.be.base.admin.service.AdminDetailBillService;
import com.example.be.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/detail-bill")
@CrossOrigin(origins = {"*"})
public class AdminDetailBillController {


    @Autowired
    private AdminDetailBillService detailBillService;

    @Autowired
    private AdminBillService billService;

    @GetMapping("/get-detail-bill-by-bill/{id}")
    public List<AdminDetailBillResponse> getAll(@PathVariable("id") Long id) {
        Bill bill = billService.findOneById(id);
        return detailBillService.getDetailBillByBill(bill);
    }

}
