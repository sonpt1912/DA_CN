package com.example.be.base.user.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserDetailBillResponse {

    private String image;

    private String nameProduct;

    private String nameColor;

    private String nameSize;

    private Long quantity;

    private BigDecimal price;

    public UserDetailBillResponse(String image, String productName, String colorName, String sizeName, Long quantity, BigDecimal price) {
        this.image = image;
        this.nameProduct = productName;
        this.nameColor = colorName;
        this.nameSize = sizeName;
        this.quantity = quantity;
        this.price = price;
    }
}
