package com.lanca.api.repository;

import com.lanca.api.model.ExpenseCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseCategoriesRepository extends JpaRepository<ExpenseCategories, Long> {
}
