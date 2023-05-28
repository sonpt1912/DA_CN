package com.example.be.base.user.controller;

import com.example.be.base.user.model.request.UserBillRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/bill")
public class UserBillController {

    @GetMapping("/add-bill")
    public void add(@RequestBody UserBillRequest userBillRequest) {



    }


}
