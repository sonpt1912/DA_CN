package com.example.be.base.user.model.response;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserCustomerResponse {

    private String userName;

    private String lastName;

    private String firstName;

    private Integer phoneNumber;

    private String email;

    public UserCustomerResponse(String userName, String lastName, String firstName, Integer phoneNumber, String email) {
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
