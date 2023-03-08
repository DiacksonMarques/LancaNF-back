package com.lanca.api.domain;

import com.lanca.api.model.ExpenseCategories;

import java.math.BigDecimal;

public class ExpenseCategoriValuesDTO extends ExpenseCategories {

    private BigDecimal valueTotalCategori;

    public void setExpenseCategories(ExpenseCategories expenseCategories) {
        this.setId(expenseCategories.getId());
        this.setNameCategori(expenseCategories.getNameCategori());
        this.setDescriptionCategori(expenseCategories.getDescriptionCategori());
        this.setFiled(expenseCategories.getFiled());
    }

    public BigDecimal getValueTotalCategori() {
        return valueTotalCategori;
    }

    public void setValueTotalCategori(BigDecimal valueTotalCategori) {
        this.valueTotalCategori = valueTotalCategori;
    }
}
