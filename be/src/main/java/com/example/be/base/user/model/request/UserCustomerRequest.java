package com.example.be.base.user.model.request;

import lombok.Data;

@Data
public class UserCustomerRequest {

    private Long id;

    private String userName;

    private String lastName;

    private String firstName;

    private Integer phoneNumber;

    private String email;


    public UserCustomerRequest(Long id, String userName, String lastName, String firstName, Integer phoneNumber, String email) {
        this.id = id;
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
