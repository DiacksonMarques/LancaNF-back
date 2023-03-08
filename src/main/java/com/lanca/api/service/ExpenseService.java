package com.lanca.api.service;


import com.lanca.api.model.Expenses;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {
    List<Expenses> getAllExpense();

    Optional<Expenses> getByIdExpense(Long id);

    Expenses insertExpense(Expenses expense);

    Expenses updateExpense(Expenses expense);

    void deleteExpense(Long id);
}
