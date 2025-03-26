package com.expensemanagement.ems_backend.repository;

import com.expensemanagement.ems_backend.entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExpenseRepository extends JpaRepository<Expenses, Long> {
}