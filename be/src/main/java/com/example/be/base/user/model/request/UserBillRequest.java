package com.example.be.base.user.model.request;

import lombok.Data;

@Data
public class UserBillRequest {

    private Long idCart;

    private String codeVoucher;

    private Long idCustomer;

    private String address;

    private String description;

}
