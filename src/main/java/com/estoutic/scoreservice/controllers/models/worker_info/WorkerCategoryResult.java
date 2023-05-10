package com.estoutic.scoreservice.controllers.models.worker_info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class WorkerCategoryResult {

    private String categoryName;
    private List<TaskResult> taskResults;

    public WorkerCategoryResult() {
    }
}
