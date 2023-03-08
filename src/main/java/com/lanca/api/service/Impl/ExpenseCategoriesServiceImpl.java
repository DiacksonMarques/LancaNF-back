package com.lanca.api.service.Impl;

import com.lanca.api.model.ExpenseCategories;
import com.lanca.api.repository.ExpenseCategoriesRepository;
import com.lanca.api.service.ExpenseCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ExpenseCategoriesServiceImpl implements ExpenseCategoriesService {
    @Autowired
    private ExpenseCategoriesRepository expenseCategoriesRepository;

    @Override
    public List<ExpenseCategories> getAllExpenseCategories() {
        return expenseCategoriesRepository.findAll();
    }

    @Override
    public Optional<ExpenseCategories> getByIdExpenseCategori(Long id) {
        return expenseCategoriesRepository.findById(id);
    }

    @Override
    public ExpenseCategories insertExpenseCategori(ExpenseCategories expenseCategories) {
        return expenseCategoriesRepository.save(expenseCategories);
    }

    @Override
    public ExpenseCategories updateExpenseCategori(ExpenseCategories expenseCategories) {
        return expenseCategoriesRepository.findById(expenseCategories.getId()).
                map(client -> {
                    return expenseCategoriesRepository.save(expenseCategories);
                })
                .orElseGet(() -> {
                    return expenseCategoriesRepository.save(expenseCategories);
                });
    }

    @Override
    public void deleteExpenseCategori(Long id) {
        expenseCategoriesRepository.deleteById(id);
    }
}
