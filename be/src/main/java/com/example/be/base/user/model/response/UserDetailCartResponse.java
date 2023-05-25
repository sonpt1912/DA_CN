package com.example.be.base.user.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserDetailCartResponse {

    private Long idDetailProduct;

    private String nameProduct;

    private String nameSize;

    private String nameColor;

    private String image;

    private Integer quantity;

    private BigDecimal price;

    public UserDetailCartResponse(Long idDetailProduct, String nameProduct, String nameSize, String nameColor, String image, Integer quantity, BigDecimal price) {
        this.idDetailProduct = idDetailProduct;
        this.nameProduct = nameProduct;
        this.nameSize = nameSize;
        this.nameColor = nameColor;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
    }
}
