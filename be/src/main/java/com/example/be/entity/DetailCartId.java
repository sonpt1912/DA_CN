package com.example.be.entity;

import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetailCartId implements Serializable {

    private Cart cart;

    private DetailProduct detailProduct;

}
