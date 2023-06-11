package com.example.be.base.admin.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AdminProductResponse {

    private String image;

    private String name;
    private BigDecimal sellPrice;

    private String description;

    public AdminProductResponse(String image, String name, BigDecimal sellPrice, String description) {
        this.image = image;
        this.name = name;
        this.sellPrice = sellPrice;
        this.description = description;
    }
}
