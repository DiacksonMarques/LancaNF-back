package com.lanca.api.controller;

import com.lanca.api.model.Company;
import com.lanca.api.model.ExpenseCategories;
import com.lanca.api.service.ExpenseCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
public class ExpenseCategoriesController {

    @Autowired
    private ExpenseCategoriesService expenseCategoriesService;

    @GetMapping("/api/expense-categories")
    public List<ExpenseCategories> getExpenseCategoriesAll(){
        return expenseCategoriesService.getAllExpenseCategories();
    }

    @GetMapping("/api/expense-categori-filter")
    public List<ExpenseCategories> getAllExpenseCategoriesFilter(){
        return expenseCategoriesService.getAllExpenseCategoriesFilter();
    }

    @GetMapping("/api/expense-categori/{id}")
    public Optional<ExpenseCategories> getExpenseCategori(@PathVariable("id") Long id){
        return expenseCategoriesService.getByIdExpenseCategori(id);
    }


    @PostMapping("/api/expense-categori")
    @ResponseStatus(HttpStatus.CREATED)
    public ExpenseCategories create(@RequestBody ExpenseCategories expenseCategories) {
        return expenseCategoriesService.insertExpenseCategori(expenseCategories);
    }

    @PutMapping("/api/expense-categori")
    public ExpenseCategories update(@RequestBody ExpenseCategories expenseCategories) {
        return expenseCategoriesService.updateExpenseCategori(expenseCategories);
    }

    @DeleteMapping("/api/expense-categori/{id}")
    public void delete(@PathVariable("id") Long id) {
        expenseCategoriesService.deleteExpenseCategori(id);
    }
}
