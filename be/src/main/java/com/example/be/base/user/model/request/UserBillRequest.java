package com.example.be.base.user.model.request;

import lombok.Data;

import java.sql.Date;

@Data
public class UserBillRequest {

    private Long idCustomer;

    private Long idVoucher;

    private Long idCart;

    private String address;

    private Integer phoneNumber;

    private String description;

}
