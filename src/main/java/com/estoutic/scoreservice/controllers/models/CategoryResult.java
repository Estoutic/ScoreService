package com.estoutic.scoreservice.controllers.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryResult {
    private String categoryName;
    private List<TaskResult> taskResults;

    public CategoryResult(String categoryName, List<TaskResult> taskResults) {
        this.categoryName = categoryName;
        this.taskResults = taskResults;
    }
}
