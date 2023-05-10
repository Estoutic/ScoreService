package com.estoutic.scoreservice.controllers.models.worker_info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TaskResult {

    private String taskName;
    private int score;
}
