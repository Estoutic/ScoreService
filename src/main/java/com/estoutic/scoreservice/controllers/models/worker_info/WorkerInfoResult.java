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
public class WorkerInfoResult {

    private String username;
    private List<WorkerCategoryResult> workerCategoryResults;
}
