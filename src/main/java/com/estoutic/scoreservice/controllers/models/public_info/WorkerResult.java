package com.estoutic.scoreservice.controllers.models.public_info;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkerResult {

    public String workerName;

    public double score;

    public WorkerResult(String workerName, double score) {
        this.workerName = workerName;
        this.score = score;
    }
}
