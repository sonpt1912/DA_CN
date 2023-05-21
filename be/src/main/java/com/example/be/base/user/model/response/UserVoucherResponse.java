package com.example.be.base.user.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserVoucherResponse {

    private long id;

    private BigDecimal discountAmount;

    public UserVoucherResponse(long id, BigDecimal discountAmount) {
        this.id = id;
        this.discountAmount = discountAmount;
    }
}
