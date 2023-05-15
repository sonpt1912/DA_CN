package com.example.be.base.user.model.response;

import lombok.Data;

@Data
public class UserSizeResponse {

    private long id;
    private String name;

    public UserSizeResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
