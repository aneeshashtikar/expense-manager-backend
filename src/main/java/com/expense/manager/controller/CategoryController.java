package com.expense.manager.controller;

import com.expense.manager.models.Category;
import com.expense.manager.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> fetchCategories() {
        var categoryIte = categoryRepository.findAll().iterator();
        var catergoryList = new ArrayList<Category>();
        while (categoryIte.hasNext()) {
            catergoryList.add(categoryIte.next());
        }
        return catergoryList;
    }
}
