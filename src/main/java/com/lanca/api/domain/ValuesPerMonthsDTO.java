package com.lanca.api.domain;

import java.math.BigDecimal;

public class ValuesPerMonthsDTO {

    private String month;

    private BigDecimal valueMonth;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public BigDecimal getValueMonth() {
        return valueMonth;
    }

    public void setValueMonth(BigDecimal valueMonth) {
        this.valueMonth = valueMonth;
    }
}
