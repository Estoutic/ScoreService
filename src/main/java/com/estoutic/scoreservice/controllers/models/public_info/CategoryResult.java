package com.estoutic.scoreservice.controllers.models.public_info;

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
    private List<WorkerResult> workerResults;

    public CategoryResult() {
    }
}
