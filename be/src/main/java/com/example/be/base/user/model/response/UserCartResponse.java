package com.example.be.base.user.model.response;

import lombok.Data;

@Data
public class UserCartResponse {

    private Long id;

    public UserCartResponse(Long id) {
        this.id = id;
    }
}
