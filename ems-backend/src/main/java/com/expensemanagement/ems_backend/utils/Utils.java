package com.expensemanagement.ems_backend.utils;

import com.expensemanagement.ems_backend.dto.UserDTO;
import com.expensemanagement.ems_backend.dto.ExpensesDTO;
import com.expensemanagement.ems_backend.entity.Expenses;
import com.expensemanagement.ems_backend.entity.User;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
        private static final String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        private static final SecureRandom secureRandom = new SecureRandom();


        public static String generateRandomConfirmationCode(int length) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < length; i++) {
                int randomIndex = secureRandom.nextInt(ALPHANUMERIC_STRING.length());
                char randomChar = ALPHANUMERIC_STRING.charAt(randomIndex);
                stringBuilder.append(randomChar);
            }
            return stringBuilder.toString();
        }


        public static UserDTO mapUserEntityToUserDTO(User user) {
            UserDTO userDTO = new UserDTO();

            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setEmail(user.getEmail());
            userDTO.setPhoneno(user.getPhoneno());
            userDTO.setRole(user.getRole());
            return userDTO;
        }

        public static ExpensesDTO mapExpensesEntityToExpensesDTO(Expenses expenses) {
            ExpensesDTO expensesDTO = new ExpensesDTO();
            // Map simple fields
            expensesDTO.setId(expenses.getId());
            expensesDTO.setAmount(expenses.getAmount());
            expensesDTO.setDate(expenses.getDate());
            expensesDTO.setCategory(expenses.getCategory());
            expensesDTO.setDescription(expenses.getDescription());
            expensesDTO.setStatus(expenses.getStatus());
            return expensesDTO;
        }

        public static UserDTO mapUserEntityToUserDTOPlusUserExpenses(User user) {
            UserDTO userDTO = new UserDTO();

            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setEmail(user.getEmail());
            userDTO.setPhoneno(user.getPhoneno());
            userDTO.setRole(user.getRole());

            if (!user.getExpenses().isEmpty()) {
                userDTO.setExpenses(user.getExpenses().stream().map(expenses -> mapExpensesEntityToExpensesDTO(expenses)).collect(Collectors.toList()));
            }
            return userDTO;
        }

        public static List<UserDTO> mapUserListEntityToUserListDTO(List<User> userList) {
            return userList.stream().map(Utils::mapUserEntityToUserDTO).collect(Collectors.toList());
        }


        public static List<ExpensesDTO> mapExpenseListEntityToExpenseListDTO(List<Expenses> expensesList) {
            return expensesList.stream().map(Utils::mapExpensesEntityToExpensesDTO).collect(Collectors.toList());
        }


}
