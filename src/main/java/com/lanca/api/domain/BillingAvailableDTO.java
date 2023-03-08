package com.lanca.api.domain;

import java.math.BigDecimal;

public class BillingAvailableDTO {

    private BigDecimal billingLimit;

    private BigDecimal totalPosted;

    public BigDecimal getBillingLimit() {
        return billingLimit;
    }

    public void setBillingLimit(BigDecimal billingLimit) {
        this.billingLimit = billingLimit;
    }

    public BigDecimal getTotalPosted() {
        return totalPosted;
    }

    public void setTotalPosted(BigDecimal totalPosted) {
        this.totalPosted = totalPosted;
    }
}
