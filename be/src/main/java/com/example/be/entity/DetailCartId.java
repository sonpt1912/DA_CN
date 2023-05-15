package com.example.be.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DetailCartId implements Serializable {

    private Long idCart;

    private Long idDetailProduct;

}
