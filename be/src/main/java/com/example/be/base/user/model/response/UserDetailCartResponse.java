package com.example.be.base.user.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserDetailCartResponse {

    private Long idDetailProduct;

    private String nameProduct;

    private String image;

    private Integer quantity;

    private BigDecimal price;

    public UserDetailCartResponse(Long idDetailProduct, String nameProduct, String image, Integer quantity, BigDecimal price) {
        this.idDetailProduct = idDetailProduct;
        this.nameProduct = nameProduct;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
    }
}
