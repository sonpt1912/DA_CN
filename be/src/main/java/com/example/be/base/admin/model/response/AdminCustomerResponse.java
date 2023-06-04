package com.example.be.base.admin.model.response;

import lombok.Data;

@Data
public class AdminCustomerResponse {

    private String firstName;

    private String lastName;


    public AdminCustomerResponse(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }
}
