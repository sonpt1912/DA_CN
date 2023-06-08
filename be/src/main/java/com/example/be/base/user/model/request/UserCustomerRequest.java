package com.example.be.base.user.model.request;

import lombok.Data;

@Data
public class UserCustomerRequest {

    private Long id;


    private String lastName;

    private String firstName;

    private Integer phoneNumber;

    private String email;


    public UserCustomerRequest(Long id, String lastName, String firstName, Integer phoneNumber, String email) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
