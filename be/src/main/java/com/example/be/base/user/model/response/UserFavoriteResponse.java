package com.example.be.base.user.model.response;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserFavoriteResponse {

    private long idCustomer;

    private long idProduct;

    private String nameProduct;

    private String image;

    private BigDecimal sellPrice;

    public UserFavoriteResponse(long idCustomer, long idProduct, String nameProduct, String image, BigDecimal sellPrice) {
        this.idCustomer = idCustomer;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.image = image;
        this.sellPrice = sellPrice;
    }
}
