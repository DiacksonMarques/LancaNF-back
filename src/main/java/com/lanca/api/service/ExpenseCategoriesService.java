package com.lanca.api.service;

import com.lanca.api.model.ExpenseCategories;

import java.util.List;
import java.util.Optional;

public interface ExpenseCategoriesService {
    List<ExpenseCategories> getAllExpenseCategories();

    Optional<ExpenseCategories> getByIdExpenseCategori(Long id);

    ExpenseCategories insertExpenseCategori(ExpenseCategories expenseCategories);

    ExpenseCategories updateExpenseCategori(ExpenseCategories expenseCategories);

    void deleteExpenseCategori(Long id);
}
