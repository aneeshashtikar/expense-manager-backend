package com.expense.manager.controller;

import com.expense.manager.models.*;
import com.expense.manager.repository.CategoryRepository;
import com.expense.manager.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionRepository transactionRepository;

    private final CategoryRepository categoryRepository;

    @GetMapping("/{phoneNumber}")
    private ExpenseTotal getExpenseReport(@PathVariable("phoneNumber") String phoneNumber) {
        var expenses = transactionRepository.getExpenses(phoneNumber);
        var expensesList = new ArrayList<ExpenseResponse>();
        for (Object[] expense : expenses) {
            expensesList.add(new ExpenseResponse((String) expense[0], (Double) expense[1]));
        }
        var total =  new ExpenseTotal();
        total.setExpenseResponses(expensesList);
        total.setTotalIncome(transactionRepository.getIncomeTotal(phoneNumber));
        total.setTotalExpenses(expensesList.stream().mapToDouble(ExpenseResponse::getAmount).sum());
        total.setSavings(total.getTotalIncome() - total.getTotalExpenses().longValue());
        return total;
    }

    @PostMapping
    public void postExpense(@RequestBody Expenses expenses) {
        var category = categoryRepository.findByName(expenses.getCategory());
        var transaction = new Transactions();
        transaction.setAmount(expenses.getAmount());
        transaction.setCategory(category);
        transaction.setLocalDate(parseDate(expenses.getDate()));
        var finAppUser = new FinAppUser();
        finAppUser.setPhoneNumber(expenses.getPhoneNumber());
        transaction.setFinAppUser(finAppUser);
        transaction.setDescription(expenses.getDescription());
        transactionRepository.save(transaction);
    }

    private LocalDate parseDate(String date) {
        try {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/M/yyyy"));
        }
    }
}
