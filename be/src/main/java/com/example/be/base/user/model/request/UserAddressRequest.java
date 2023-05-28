package com.example.be.base.user.model.request;

import lombok.Data;

@Data
public class UserAddressRequest {

    private Long idCustomer;

    private String city;

    private String district;

    private String ward;

    private String description;
}
