package com.expensemanagement.ems_backend.controller;

import com.expensemanagement.ems_backend.dto.Response;
import com.expensemanagement.ems_backend.entity.Expenses;
import com.expensemanagement.ems_backend.service.interf.IExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

public class ExpensesController {
    @Autowired
    private IExpensesService expensesService;

    @PostMapping("/add-expense/{userId}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public ResponseEntity<Response> saveExpenses(@PathVariable Long roomId,
                                                 @PathVariable Long userId,
                                                 @RequestBody Expenses expensesRequest) {

        Response response = expensesService.createExpense(userId, expensesRequest);
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response> getAllBookings() {
        Response response = expensesService.getAllExpenses();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
/*
    @GetMapping("/get-by-confirmation-code/{confirmationCode}")
    public ResponseEntity<Response> getBookingByConfirmationCode(@PathVariable String confirmationCode) {
        Response response = expensesService.findBookingByConfirmationCode(confirmationCode);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
*/
    @DeleteMapping("/cancel/{expenseId}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public ResponseEntity<Response> cancelExpense(@PathVariable Long expenseId) {
        Response response = expensesService.cancelExpense(expenseId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

}
