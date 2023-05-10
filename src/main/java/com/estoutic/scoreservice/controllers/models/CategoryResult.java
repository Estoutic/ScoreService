package com.estoutic.scoreservice.controllers.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CategoryResult {
    private String categoryName;
    private List<TaskResult> taskResults;
    private List<WorkerResult> workerResults;

    public CategoryResult() {
    }
}
