package com.expensemanagement.ems_backend.service.interf;

import com.expensemanagement.ems_backend.dto.LoginRequest;
import com.expensemanagement.ems_backend.dto.Response;
import com.expensemanagement.ems_backend.entity.User;

public interface IUserService {
    Response login(LoginRequest loginRequest);
    Response register(User user);
    Response getAllUsers();
    Response getUserExpenseHistory(String userId);
    Response deleteUser(String userId);
    Response getUserById(String userId);
    Response getMyInfo(String email);
}
