package com.expensemanagement.ems_backend.service.Impl;

import com.expensemanagement.ems_backend.dto.ExpensesDTO;
import com.expensemanagement.ems_backend.dto.Response;
import com.expensemanagement.ems_backend.entity.Expenses;
import com.expensemanagement.ems_backend.entity.User;
import com.expensemanagement.ems_backend.exception.OurException;
import com.expensemanagement.ems_backend.repository.ExpenseRepository;
import com.expensemanagement.ems_backend.repository.UserRepository;
import com.expensemanagement.ems_backend.service.interf.IExpensesService;
import com.expensemanagement.ems_backend.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesService implements IExpensesService {
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Response createExpense(Long userId, Expenses expenseRequest) {
        Response response = new Response();

        try {
            User user = userRepository.findById(userId).orElseThrow(() -> new OurException("User Not Found"));
            List<Expenses> existingExpenses = user.getExpenses();

            expenseRequest.setUser(user);
            expenseRepository.save(expenseRequest);
            response.setStatusCode(200);
            response.setMessage("successful");

        } catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());

        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error Adding a Expense: " + e.getMessage());
        }
        return response;
    }

    @Override
    public Response getAllExpenses() {
        Response response = new Response();

        try {
            List<Expenses> expensesList = expenseRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
            List<ExpensesDTO> expensesDTOList = Utils.mapExpenseListEntityToExpenseListDTO(expensesList);
            response.setStatusCode(200);
            response.setMessage("successful");
            response.setExpenseList(expensesDTOList);
        } catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());

        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error Getting all expenses: " + e.getMessage());
        }
        return response;
    }

    @Override
    public Response cancelExpense(Long expenseId) {
        Response response = new Response();

        try {
            expenseRepository.findById(expenseId).orElseThrow(() -> new OurException("Expense Does Not Exist"));
            expenseRepository.deleteById(expenseId);
            response.setStatusCode(200);
            response.setMessage("successful");

        } catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());

        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error Cancelling a expense: " + e.getMessage());

        }
        return response;
    }
}
