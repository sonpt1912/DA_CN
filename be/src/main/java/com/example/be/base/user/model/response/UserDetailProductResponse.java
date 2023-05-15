package com.example.be.base.user.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserDetailProductResponse {

    private Long id;

    private String product;

    private String image;

    private String category;

    private String brand;

    private String color;

    private String size;

    private String description;

    private BigDecimal sellPrice;

    public UserDetailProductResponse(Long id, String product, String image, String category, String brand, String color, String size, String description, BigDecimal sellPrice) {
        this.id = id;
        this.product = product;
        this.image = image;
        this.category = category;
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.description = description;
        this.sellPrice = sellPrice;
    }

    public UserDetailProductResponse(Long id, String product, String image, String description, BigDecimal sellPrice) {
        this.id = id;
        this.product = product;
        this.image = image;
        this.description = description;
        this.sellPrice = sellPrice;
    }
}
