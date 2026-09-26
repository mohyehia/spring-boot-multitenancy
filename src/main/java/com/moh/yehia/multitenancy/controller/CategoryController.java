package com.moh.yehia.multitenancy.controller;

import com.moh.yehia.multitenancy.model.Category;
import com.moh.yehia.multitenancy.repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }
}
