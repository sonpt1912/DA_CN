package com.example.be.base.user.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserProductResponse {

    private long id;

    private String name;

    private String category;

    private String image;

    private BigDecimal sellPrice;

    public UserProductResponse(long id, String name, String category, String image, BigDecimal sellPrice) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.image = image;
        this.sellPrice = sellPrice;
    }
}
