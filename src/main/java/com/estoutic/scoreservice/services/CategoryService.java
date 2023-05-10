package com.estoutic.scoreservice.services;

import com.estoutic.scoreservice.controllers.models.CategoryResult;

public interface CategoryService {

    String save(String name);

    CategoryResult getAllCategoryInfo(String id);

}
