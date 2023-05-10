package com.estoutic.scoreservice.controllers.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class TaskResult {
    private String id;
    private String workerName;
    private Map<String, Integer> results;

    public TaskResult(String id, String workerName, Map<String, Integer> results) {
        this.id = id;
        this.workerName = workerName;
        this.results = results;
    }
}
