package com.lanca.api.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "BILLING_LIMIT")
public class BillingLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;

    @Column(name = "LIMIT_BILLING")
    private BigDecimal limit;

    @Column(name = "ALERT_BILLING", nullable = false)
    private boolean alert = true;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public boolean isAlert() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
    }
}
