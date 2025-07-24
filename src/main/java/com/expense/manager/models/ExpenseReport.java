package com.expense.manager.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ExpenseReport {
    String name;
    Double amount;
}
