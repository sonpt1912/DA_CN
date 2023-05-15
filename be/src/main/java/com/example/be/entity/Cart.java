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

import java.sql.Date;

@Entity
@Table(name = "cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_customer", nullable = false, referencedColumnName = "id")
    private Customer customer;

    @Column(name = "code", nullable = false)
    private Integer code;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "payment_date")
    private Date paymentDate;

    @Column(name = "received_date")
    private Date receivedDate;

    @Column(name = "name_customer")
    private String nameCustomer;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Column(name = "status")
    private Integer status;

}
