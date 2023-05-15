package com.example.be.base.user.model.response;

import lombok.Data;

@Data
public class UserColorResponse {

    private long id;
    private String name;

    public UserColorResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
