package com.example.be.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "detail_cart")
@Getter
@IdClass(DetailCart.class)
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetailCart {

    @Id
    @ManyToOne()
    @JoinColumn(name = "id_cart", nullable = false, referencedColumnName = "id")
    private Cart cart;

    @Id
    @ManyToOne()
    @JoinColumn(name = "id_detail_product", nullable = false, referencedColumnName = "id")
    private DetailProduct detailProduct;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private BigDecimal price;

}
