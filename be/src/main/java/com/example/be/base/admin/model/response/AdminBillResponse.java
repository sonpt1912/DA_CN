package com.example.be.base.admin.model.response;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class AdminBillResponse {

    private Long id;

    private Long code;

    private Long quantity;

    private Long totalPrice;

    private Integer phoneNumber;

    private Date orderDate;

    private Date paymentDate;

    private String address;

    private String description;

    private Integer status;

    public AdminBillResponse(Long id, Long code, Long quantity, Long totalPrice, Integer phoneNumber, Date orderDate, Date paymentDate, String address, String description, Integer status) {
        this.id = id;
        this.code = code;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.phoneNumber = phoneNumber;
        this.orderDate = orderDate;
        this.paymentDate = paymentDate;
        this.address = address;
        this.description = description;
        this.status = status;
    }
}
