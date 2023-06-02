package com.example.be.base.user.controller;

import com.example.be.base.user.model.response.UserDetailBillResponse;
import com.example.be.base.user.service.UserBillService;
import com.example.be.base.user.service.UserDetailBillService;
import com.example.be.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/detail-bill")
@CrossOrigin(origins = {"*"})
public class UserDetailBillController {

    @Autowired
    private UserDetailBillService detailBillService;

    @Autowired
    private UserBillService billService;

    @GetMapping("/get-by-bill/{id}")
    public List<UserDetailBillResponse> getAllByBill(@PathVariable("id") Long idBill) {
        Bill bill = billService.getOneById(idBill);
        return detailBillService.getListDetailBillByBill(bill);
    }

}
