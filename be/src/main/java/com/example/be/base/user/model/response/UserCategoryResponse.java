package com.example.be.base.user.model.response;

import lombok.Data;

@Data
public class UserCategoryResponse {

    private long id;
    private String name;

    public UserCategoryResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
