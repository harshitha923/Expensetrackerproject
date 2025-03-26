package com.expensemanagement.ems_backend.dto;

import com.expensemanagement.ems_backend.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExpensesDTO {
    private long id;
    private Double amount;
    private String category;
    private LocalDate date;
    private String description;
    private String status;
    private UserDTO user;

}
