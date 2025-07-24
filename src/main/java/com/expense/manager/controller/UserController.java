package com.expense.manager.controller;

import com.expense.manager.models.FinAppUser;
import com.expense.manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @PostMapping
    public FinAppUser createUser(@RequestBody FinAppUser user) {
        return userRepository.save(user);
    }
}
