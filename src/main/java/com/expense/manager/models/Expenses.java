package com.expense.manager.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Expenses {

    private String category;

    private double amount;

    private String description;

    private String date;

    private String phoneNumber;
}
