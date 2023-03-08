package com.lanca.api.service.Impl;

import com.lanca.api.model.Expenses;
import com.lanca.api.repository.ExpensesRepository;
import com.lanca.api.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpensesRepository expensesRepository;

    @Override
    public List<Expenses> getAllExpense() {
        return expensesRepository.findAll();
    }

    @Override
    public Optional<Expenses> getByIdExpense(Long id) {
        return expensesRepository.findById(id);
    }

    @Override
    public Expenses insertExpense(Expenses expense) {
        return expensesRepository.save(expense);
    }

    @Override
    public Expenses updateExpense(Expenses expense) {
        return expensesRepository.findById(expense.getId()).
                map(client -> {
                    return expensesRepository.save(expense);
                })
                .orElseGet(() -> {
                    return expensesRepository.save(expense);
                });
    }

    @Override
    public void deleteExpense(Long id) {
        expensesRepository.deleteById(id);
    }
}
