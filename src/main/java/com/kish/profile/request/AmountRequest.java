package com.kish.profile.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AmountRequest {

    private BigDecimal amount;
    private String currencyType;
    private BigDecimal exchangeRate;

    public BigDecimal getAmountInEuro(){
        return amount.multiply(exchangeRate);
    }
}
