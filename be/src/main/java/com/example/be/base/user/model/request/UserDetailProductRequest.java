package com.example.be.base.user.model.request;

import lombok.Data;

@Data
public class UserDetailProductRequest {

    private Long idProduct;

    private Long idCategory;

    private Long idBrand;

    private Long idColor;

    private Long idSize;

    private Integer quantity;

}
