package com.estoutic.scoreservice.services.impl;

import com.estoutic.scoreservice.database.models.Category;
import com.estoutic.scoreservice.database.repositories.CategoryRepository;
import com.estoutic.scoreservice.services.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String save(String name) {
        Category category = Category.builder().name(name).build();
        categoryRepository.save(category);

        return category.getId();
    }
}
