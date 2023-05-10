package com.estoutic.scoreservice.controllers.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class TaskResult {
    private String id;
    private String taskName;
    private Map<String, Integer> results;

    public TaskResult(String id, String taskName, Map<String, Integer> results) {
        this.id = id;
        this.taskName = taskName;
        this.results = results;
    }
}
