package com.expense.manager.repository;

import com.expense.manager.models.QuestionsAndAnswers;
import org.springframework.data.repository.CrudRepository;

public interface QnARepository extends CrudRepository<QuestionsAndAnswers, String> {
}
