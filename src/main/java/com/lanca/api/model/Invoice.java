package com.lanca.api.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "INVOICE")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;

    @Column(name = "VALUE_INVOICE")
    private BigDecimal valueInvoice;

    @Column(name = "NUMBER_INVOICE")
    private Long numberInvoice;

    @Column(name = "DESCRIPTION_Invoice", nullable = false, length = 5000)
    private String descriptioninvoice;

    @Column(name = "MONTH_INVOICE")
    private BigDecimal monthInvoice;

    @Column(name = "RECEIPT_DATE")
    private Date receiptDate;

    @ManyToOne(targetEntity = Company.class, fetch = FetchType.EAGER, cascade={CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")
    private Company company;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public BigDecimal getValueInvoice() {
        return valueInvoice;
    }

    public void setValueInvoice(BigDecimal valueInvoice) {
        this.valueInvoice = valueInvoice;
    }

    public Long getNumberInvoice() {
        return numberInvoice;
    }

    public void setNumberInvoice(Long numberInvoice) {
        this.numberInvoice = numberInvoice;
    }

    public String getDescriptioninvoice() {
        return descriptioninvoice;
    }

    public void setDescriptioninvoice(String descriptioninvoice) {
        this.descriptioninvoice = descriptioninvoice;
    }

    public BigDecimal getMonthInvoice() {
        return monthInvoice;
    }

    public void setMonthInvoice(BigDecimal monthInvoice) {
        this.monthInvoice = monthInvoice;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
