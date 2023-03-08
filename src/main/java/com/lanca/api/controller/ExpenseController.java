package com.lanca.api.controller;

import com.lanca.api.model.Expenses;
import com.lanca.api.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/api/expenses")
    public List<Expenses> getExpenseCategoriesAll(){
        return expenseService.getAllExpense();
    }

    @GetMapping("/api/expense/{id}")
    public Optional<Expenses> getExpenseCategori(@PathVariable("id") Long id){
        return expenseService.getByIdExpense(id);
    }

    @PostMapping("/api/expense")
    @ResponseStatus(HttpStatus.CREATED)
    public Expenses create(@RequestBody Expenses expense) {
        return expenseService.insertExpense(expense);
    }

    @PutMapping("/api/expense")
    public Expenses update(@RequestBody Expenses expense) {
        return expenseService.updateExpense(expense);
    }

    @DeleteMapping("/api/expense/{id}")
    public void delete(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
    }
}
