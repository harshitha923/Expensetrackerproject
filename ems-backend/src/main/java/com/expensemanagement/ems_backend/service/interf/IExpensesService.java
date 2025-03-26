package com.expensemanagement.ems_backend.service.interf;

import com.expensemanagement.ems_backend.dto.Response;
import com.expensemanagement.ems_backend.entity.Expenses;

public interface IExpensesService {
    Response createExpense(Long userId, Expenses expenseRequest);
    Response getAllExpenses();
    Response cancelExpense(Long expenseId);
    //Response getExpenseStatus(Long expenseId);

}
