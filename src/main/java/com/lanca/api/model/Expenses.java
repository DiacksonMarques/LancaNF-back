package com.lanca.api.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "EXPENSES")
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;

    @Column(name = "EXPENSE_AMOUNT")
    private BigDecimal expenseAmount;

    @Column(name = "EXPENSE_NAME")
    private String expenseName;

    @Column(name = "ACCRUAL_DATE")
    private Date accrualDate;

    @Column(name = "PAY_DAY")
    private Date payDay;

    @ManyToOne(targetEntity = ExpenseCategories.class, fetch = FetchType.EAGER, cascade={CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "EXPENSES_CATEGORI_ID", referencedColumnName = "ID")
    private ExpenseCategories expenseCategori;

    @ManyToOne(targetEntity = Company.class, fetch = FetchType.EAGER, cascade={CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")
    private Company company;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public BigDecimal getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(BigDecimal expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public Date getAccrualDate() {
        return accrualDate;
    }

    public void setAccrualDate(Date accrualDate) {
        this.accrualDate = accrualDate;
    }

    public Date getPayDay() {
        return payDay;
    }

    public void setPayDay(Date payDay) {
        this.payDay = payDay;
    }

    public ExpenseCategories getExpenseCategori() {
        return expenseCategori;
    }

    public void setExpenseCategori(ExpenseCategories expenseCategori) {
        this.expenseCategori = expenseCategori;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
