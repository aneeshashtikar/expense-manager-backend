package com.expense.manager.controller;

import com.expense.manager.models.Question;
import com.expense.manager.repository.QnARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/answer")
@RestController
public class QAndAController {

    private final QnARepository qnARepository;

    @PostMapping
    public String getAnswer(@RequestBody Question question){
        var answer = qnARepository.findById(question.getQuestion());
        if(answer.isEmpty()){
            return "Please ask the right question.";
        }
        return answer.get().getAnswer();
    }
}
