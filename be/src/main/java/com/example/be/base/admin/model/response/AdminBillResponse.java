package com.example.be.base.admin.model.response;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class AdminBillResponse {

    private Long id;

    private Long code;

    private Long quantity;

    private Integer totalPrice;

    private Integer phoneNumber;

    private Date orderDate;

    private Integer status;

    public AdminBillResponse(Long id, Long code, Long quantity, Integer totalPrice, Integer phoneNumber, Date orderDate, Integer status) {
        this.id = id;
        this.code = code;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.phoneNumber = phoneNumber;
        this.orderDate = orderDate;
        this.status = status;
    }
}
