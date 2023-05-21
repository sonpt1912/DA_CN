package com.example.be.base.user.model.response;

import lombok.Data;

@Data
public class UserAddressResponse {

    private long idAddress;

    private String description;

    private String ward;

    private String district;

    private String city;

    public UserAddressResponse(long idAddress, String description, String ward, String district, String city) {
        this.idAddress = idAddress;
        this.description = description;
        this.ward = ward;
        this.district = district;
        this.city = city;
    }
}
