package com.expensemanagement.ems_backend.dto;


import com.expensemanagement.ems_backend.entity.Expenses;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private  long id;
    private String email;
    private String name;
    private String password;
    private String phoneno;
    private String role;
    private List<ExpensesDTO> expenses = new ArrayList<>();


}
