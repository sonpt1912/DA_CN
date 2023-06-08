package com.example.be.base.admin.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AdminChartResponse {

    private Integer month;

    private BigDecimal totalMoney;

    public AdminChartResponse(Integer month, BigDecimal totalMoney) {
        this.month = month;
        this.totalMoney = totalMoney;
    }
}
