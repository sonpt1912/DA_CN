package com.example.be.base.user.model.response;

import lombok.Data;

@Data
public class UserBrandResponse {

    private long id;
    private String name;

    public UserBrandResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
