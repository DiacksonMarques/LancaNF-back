package com.lanca.api.repository;

import com.lanca.api.model.ExpenseCategories;
import com.lanca.api.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ExpenseCategoriesRepository extends JpaRepository<ExpenseCategories, Long> {
    @Query("select ex.id from ExpenseCategories ex")
    ArrayList<Long> expenseCategoriId();

    @Query("select ex from ExpenseCategories ex where ex.filed = false")
    List<ExpenseCategories> findFilterFiled();
}
