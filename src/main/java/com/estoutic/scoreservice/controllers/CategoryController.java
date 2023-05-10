package com.estoutic.scoreservice.controllers;

import com.estoutic.scoreservice.controllers.models.CategoryResult;
import com.estoutic.scoreservice.services.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public String addCategory(@RequestParam() String categoryName) {
        return categoryService.save(categoryName);
    }

    @GetMapping("/{id}/all")
    public CategoryResult findAllCategoryInfo(@PathVariable(name = "id") String categoryId){
        return categoryService.getAllCategoryInfo(categoryId);
    }

}
