package com.example.be.base.user.model.response;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class UserBillResponse {

    private Long id;

    private Long code;

    private Long quantity;

    private Long totalPrice;

    private Integer phoneNumber;

    private Date orderDate;

    private Date paymentDate;

    private String address;

    private Integer status;

    public UserBillResponse(Long id, Long code, Long quantity, Long totalPrice, Integer phoneNumber, Date orderDate, Date paymentDate, String address, Integer status) {
        this.id = id;
        this.code = code;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.phoneNumber = phoneNumber;
        this.orderDate = orderDate;
        this.paymentDate = paymentDate;
        this.address = address;
        this.status = status;
    }
}
