package com.expense.manager.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ExpenseTotal {
    Long totalIncome;
    Double totalExpenses;
    Long savings;
    List<ExpenseResponse> expenseResponses;
}
