package com.example.expensetracker.service;

import com.example.expensetracker.dto.ExpenseDTO;
import com.example.expensetracker.exception.ResourceNotFoundException;
import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExpenseServiceTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @InjectMocks
    private ExpenseService expenseService;

    private Expense expense;
    private ExpenseDTO expenseDTO;

    @BeforeEach
    public void setUp() {
        expense = Expense.builder()
                .id(1L)
                .description("Groceries")
                .amount(new BigDecimal("50.00"))
                .category("Food")
                .userId("user1")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        expenseDTO = ExpenseDTO.builder()
                .id(1L)
                .description("Groceries")
                .amount(new BigDecimal("50.00"))
                .category("Food")
                .userId("user1")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    @Test
    public void testGetAllExpenses() {
        List<Expense> expenses = new ArrayList<>();
        expenses.add(expense);
        
        when(expenseRepository.findAll()).thenReturn(expenses);

        List<ExpenseDTO> result = expenseService.getAllExpenses();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Groceries", result.get(0).getDescription());
        verify(expenseRepository, times(1)).findAll();
    }

    @Test
    public void testGetExpenseById() {
        when(expenseRepository.findById(1L)).thenReturn(Optional.of(expense));

        ExpenseDTO result = expenseService.getExpenseById(1L);

        assertNotNull(result);
        assertEquals("Groceries", result.getDescription());
        assertEquals(new BigDecimal("50.00"), result.getAmount());
        verify(expenseRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetExpenseByIdNotFound() {
        when(expenseRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            expenseService.getExpenseById(999L);
        });
    }

    @Test
    public void testCreateExpense() {
        when(expenseRepository.save(any(Expense.class))).thenReturn(expense);

        ExpenseDTO result = expenseService.createExpense(expenseDTO);

        assertNotNull(result);
        assertEquals("Groceries", result.getDescription());
        verify(expenseRepository, times(1)).save(any(Expense.class));
    }

    @Test
    public void testUpdateExpense() {
        when(expenseRepository.findById(1L)).thenReturn(Optional.of(expense));
        when(expenseRepository.save(any(Expense.class))).thenReturn(expense);

        ExpenseDTO updatedDTO = ExpenseDTO.builder()
                .description("New Groceries")
                .amount(new BigDecimal("75.00"))
                .category("Food")
                .build();

        ExpenseDTO result = expenseService.updateExpense(1L, updatedDTO);

        assertNotNull(result);
        assertEquals("New Groceries", result.getDescription());
        verify(expenseRepository, times(1)).findById(1L);
        verify(expenseRepository, times(1)).save(any(Expense.class));
    }

    @Test
    public void testDeleteExpense() {
        when(expenseRepository.findById(1L)).thenReturn(Optional.of(expense));
        doNothing().when(expenseRepository).delete(any(Expense.class));

        expenseService.deleteExpense(1L);

        verify(expenseRepository, times(1)).findById(1L);
        verify(expenseRepository, times(1)).delete(any(Expense.class));
    }

    @Test
    public void testGetExpensesByUserId() {
        List<Expense> expenses = new ArrayList<>();
        expenses.add(expense);
        
        when(expenseRepository.findByUserId("user1")).thenReturn(expenses);

        List<ExpenseDTO> result = expenseService.getExpensesByUserId("user1");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("user1", result.get(0).getUserId());
        verify(expenseRepository, times(1)).findByUserId("user1");
    }

    @Test
    public void testGetExpensesByCategory() {
        List<Expense> expenses = new ArrayList<>();
        expenses.add(expense);
        
        when(expenseRepository.findByCategory("Food")).thenReturn(expenses);

        List<ExpenseDTO> result = expenseService.getExpensesByCategory("Food");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Food", result.get(0).getCategory());
        verify(expenseRepository, times(1)).findByCategory("Food");
    }
}
