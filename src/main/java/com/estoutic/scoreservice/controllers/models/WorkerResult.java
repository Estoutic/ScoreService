package com.estoutic.scoreservice.controllers.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkerResult {

    public String workerName;

    public int score;

    public WorkerResult(String workerName, int score) {
        this.workerName = workerName;
        this.score = score;
    }
}
