package com.example.be.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "detail_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetailProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_brand", referencedColumnName = "id", nullable = false)
    private Brand brand;

    @ManyToOne()
    @JoinColumn(name = "id_color", referencedColumnName = "id", nullable = false)
    private Color color;

    @ManyToOne()
    @JoinColumn(name = "id_product", referencedColumnName = "id", nullable = false)
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "id_size", referencedColumnName = "id", nullable = false)
    private Size size;

    @ManyToOne()
    @JoinColumn(name = "id_category", referencedColumnName = "id", nullable = false)
    private Category category;


    @Column(name = "sell_price", nullable = false)
    private BigDecimal sellPrice;

    @Column(name = "status", nullable = false)
    private Integer status;


}
