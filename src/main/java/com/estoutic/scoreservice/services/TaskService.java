package com.estoutic.scoreservice.services;

public interface TaskService {

    String saveTask(String categoryId, String taskName);

    String saveUserTaskResult(String taskId, String userId, int score);
}
