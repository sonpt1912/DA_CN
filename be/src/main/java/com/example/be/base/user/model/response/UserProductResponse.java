package com.example.be.base.user.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserProductResponse {

    private long id;

    private String name;


    private String image;

    private BigDecimal sellPrice;

    public UserProductResponse(long id, String name, String image, BigDecimal sellPrice) {
        this.id = id;
        this.name = name;

        this.image = image;
        this.sellPrice = sellPrice;
    }
}
