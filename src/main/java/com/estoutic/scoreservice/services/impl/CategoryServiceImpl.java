package com.estoutic.scoreservice.services.impl;

import com.estoutic.scoreservice.controllers.models.CategoryResult;
import com.estoutic.scoreservice.controllers.models.TaskResult;
import com.estoutic.scoreservice.database.models.Category;
import com.estoutic.scoreservice.database.models.task.Task;
import com.estoutic.scoreservice.database.models.task.WorkerTaskResult;
import com.estoutic.scoreservice.database.repositories.CategoryRepository;
import com.estoutic.scoreservice.database.repositories.task.TaskRepository;
import com.estoutic.scoreservice.database.repositories.task.WorkerTaskResultRepository;
import com.estoutic.scoreservice.services.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final WorkerTaskResultRepository workerTaskResultRepository;
    private  final TaskRepository taskRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, WorkerTaskResultRepository workerTaskResultRepository, TaskRepository taskRepository) {
        this.categoryRepository = categoryRepository;
        this.workerTaskResultRepository = workerTaskResultRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public String save(String name) {
        Category category = Category.builder().name(name).build();
        categoryRepository.save(category);

        return category.getId();
    }

    @Override
    @Transactional
    public CategoryResult getAllCategoryInfo(String categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category == null) {
            return null;
        }

        List<Task> tasks = category.getTasks();
        List<TaskResult> taskResults = new ArrayList<>();

        for (Task task : tasks) {
            String taskId = task.getId();
            String taskName = task.getName();
            Map<String, Integer> workerToScore = new HashMap<>();

            for (WorkerTaskResult workerResult : task.getTaskResults()) {
                String workerName = workerResult.getWorker().getUsername();
                int score = workerResult.getScore();
                if(workerToScore.containsKey(workerName)) {
                    workerToScore.put(workerName, workerToScore.get(workerName) + score);
                }
                else{
                    workerToScore.put(workerName, score);
                }
            }

            taskResults.add(new TaskResult(taskId, taskName, workerToScore));
        }

        return new CategoryResult(category.getName(), taskResults);
    }



}
