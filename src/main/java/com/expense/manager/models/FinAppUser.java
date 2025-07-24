package com.expense.manager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class FinAppUser {

    @Id
    private String phoneNumber;

    private String language;

    private String income;

    @OneToMany(mappedBy = "finAppUser")
    private List<Transactions> transactions;
}
