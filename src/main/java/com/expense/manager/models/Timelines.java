package com.expense.manager.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class Timelines {
    private LocalDate start;

    private LocalDate end;
}
