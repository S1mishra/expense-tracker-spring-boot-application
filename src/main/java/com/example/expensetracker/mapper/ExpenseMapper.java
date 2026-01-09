package com.example.expensetracker.mapper;

import com.example.expensetracker.dto.ExpenseDTO;
import com.example.expensetracker.model.Expense;

public class ExpenseMapper {

    public static ExpenseDTO toDTO(Expense expense) {
        if (expense == null) {
            return null;
        }
        return ExpenseDTO.builder()
                .id(expense.getId())
                .description(expense.getDescription())
                .amount(expense.getAmount())
                .category(expense.getCategory())
                .createdAt(expense.getCreatedAt())
                .updatedAt(expense.getUpdatedAt())
                .userId(expense.getUserId())
                .build();
    }

    public static Expense toEntity(ExpenseDTO expenseDTO) {
        if (expenseDTO == null) {
            return null;
        }
        return Expense.builder()
                .id(expenseDTO.getId())
                .description(expenseDTO.getDescription())
                .amount(expenseDTO.getAmount())
                .category(expenseDTO.getCategory())
                .createdAt(expenseDTO.getCreatedAt())
                .updatedAt(expenseDTO.getUpdatedAt())
                .userId(expenseDTO.getUserId())
                .build();
    }
}
