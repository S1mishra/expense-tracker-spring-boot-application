package com.example.expensetracker.controller;

import com.example.expensetracker.dto.ApiResponse;
import com.example.expensetracker.dto.ExpenseDTO;
import com.example.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ExpenseDTO>>> getAllExpenses() {
        List<ExpenseDTO> expenses = expenseService.getAllExpenses();
        ApiResponse<List<ExpenseDTO>> response = new ApiResponse<>(200, "Expenses retrieved successfully", expenses);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ExpenseDTO>> getExpenseById(@PathVariable Long id) {
        ExpenseDTO expense = expenseService.getExpenseById(id);
        ApiResponse<ExpenseDTO> response = new ApiResponse<>(200, "Expense retrieved successfully", expense);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<ExpenseDTO>>> getExpensesByUserId(@PathVariable String userId) {
        List<ExpenseDTO> expenses = expenseService.getExpensesByUserId(userId);
        ApiResponse<List<ExpenseDTO>> response = new ApiResponse<>(200, "User expenses retrieved successfully", expenses);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<ApiResponse<List<ExpenseDTO>>> getExpensesByCategory(@PathVariable String category) {
        List<ExpenseDTO> expenses = expenseService.getExpensesByCategory(category);
        ApiResponse<List<ExpenseDTO>> response = new ApiResponse<>(200, "Category expenses retrieved successfully", expenses);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ExpenseDTO>> createExpense(@Valid @RequestBody ExpenseDTO expenseDTO) {
        ExpenseDTO createdExpense = expenseService.createExpense(expenseDTO);
        ApiResponse<ExpenseDTO> response = new ApiResponse<>(201, "Expense created successfully", createdExpense);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ExpenseDTO>> updateExpense(@PathVariable Long id, @Valid @RequestBody ExpenseDTO expenseDTO) {
        ExpenseDTO updatedExpense = expenseService.updateExpense(id, expenseDTO);
        ApiResponse<ExpenseDTO> response = new ApiResponse<>(200, "Expense updated successfully", updatedExpense);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        ApiResponse<String> response = new ApiResponse<>(200, "Expense deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
