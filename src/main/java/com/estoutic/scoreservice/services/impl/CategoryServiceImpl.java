package com.estoutic.scoreservice.services.impl;

import com.estoutic.scoreservice.controllers.models.CategoryResult;
import com.estoutic.scoreservice.controllers.models.WorkerResult;
import com.estoutic.scoreservice.database.models.Category;
import com.estoutic.scoreservice.database.models.Worker;
import com.estoutic.scoreservice.database.models.task.Task;
import com.estoutic.scoreservice.database.models.task.WorkerTaskResult;
import com.estoutic.scoreservice.database.repositories.CategoryRepository;
import com.estoutic.scoreservice.database.repositories.WorkerRepository;
import com.estoutic.scoreservice.database.repositories.task.TaskRepository;
import com.estoutic.scoreservice.database.repositories.task.WorkerTaskResultRepository;
import com.estoutic.scoreservice.services.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final WorkerTaskResultRepository workerTaskResultRepository;
    private final TaskRepository taskRepository;
    private final WorkerRepository workerRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, WorkerTaskResultRepository workerTaskResultRepository, TaskRepository taskRepository, WorkerRepository workerRepository) {
        this.categoryRepository = categoryRepository;
        this.workerTaskResultRepository = workerTaskResultRepository;
        this.taskRepository = taskRepository;

        this.workerRepository = workerRepository;
    }

    @Override
    public String save(String name) {
        Category category = Category.builder().name(name).build();
        categoryRepository.save(category);

        return category.getId();
    }

    @Override
    @Transactional
    public CategoryResult getAllCategoryInfo(String categoryId)  {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException());

        Map<String, Map<String, Double>> allTaskResults = new HashMap<>();

        for (Task task : category.getTasks()) {
            Map<String, Double> results = new HashMap<>();
            for (WorkerTaskResult workerTaskResult : task.getTaskResults()) {
                String workerName = workerTaskResult.getWorker().getUsername();
                Double score = Double.valueOf(workerTaskResult.getScore());
                if (!results.containsKey(workerName)) {
                    results.put(workerName, score);
                } else {
                    Double oldScore = results.get(workerName);
                    results.put(workerName, oldScore + score);
                }
            }
            allTaskResults.put(task.getName(), results);
        }

        List<WorkerResult> workerResults = new ArrayList<>();

        for (Worker worker : workerRepository.findAll()) {
            double totalScore = 0;
            double totalTasks = 0;
            for (Task task : category.getTasks()) {
                Map<String, Double> results = allTaskResults.get(task.getName());
                Double workerScore = results != null && results.containsKey(worker.getUsername()) ? results.get(worker.getUsername()) : 0;
                if (workerScore > 0) {
                    totalTasks++;
                    totalScore += workerScore;
                }
            }
            double averageScore = totalTasks > 0 ? totalScore / totalTasks : 0;
            workerResults.add(new WorkerResult(worker.getUsername(), averageScore));
        }
        Collections.sort(workerResults, Comparator.comparing(WorkerResult::getScore).reversed());

        return CategoryResult.builder()
                .categoryName(category.getName())
                .workerResults(workerResults)
                .build();
    }
}
