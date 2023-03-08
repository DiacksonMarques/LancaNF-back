package com.lanca.api.repository;

import com.lanca.api.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {

    @Query("select ex from Expenses ex where year(ex.payDay) = :year")
    List<Expenses> expensePerYear(Integer year);


}
