package com.example.be.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "favorite")
@IdClass(FavoriteId.class)
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Favorite {

    @Id
    @ManyToOne()
    @JoinColumn(name = "id_customer", nullable = false)
    private Customer customer;

    @Id
    @ManyToOne()
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;


}
