package com.expense.manager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class QuestionsAndAnswers {

    @Id
    private String question;

    private String answer;
}
