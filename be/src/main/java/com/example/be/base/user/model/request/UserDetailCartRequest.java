package com.example.be.base.user.model.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserDetailCartRequest {

    private long idCart;

    private long idDetailProduct;

    private Integer quantity;

}
