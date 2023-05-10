package com.estoutic.scoreservice.services.impl;

import com.estoutic.scoreservice.controllers.models.worker_info.TaskResult;
import com.estoutic.scoreservice.controllers.models.worker_info.WorkerCategoryResult;
import com.estoutic.scoreservice.controllers.models.worker_info.WorkerInfoResult;
import com.estoutic.scoreservice.database.models.Category;
import com.estoutic.scoreservice.database.models.Worker;
import com.estoutic.scoreservice.database.models.task.Task;
import com.estoutic.scoreservice.database.models.task.WorkerTaskResult;
import com.estoutic.scoreservice.database.repositories.CategoryRepository;
import com.estoutic.scoreservice.database.repositories.WorkerRepository;
import com.estoutic.scoreservice.database.repositories.task.TaskRepository;
import com.estoutic.scoreservice.database.repositories.task.WorkerTaskResultRepository;
import com.estoutic.scoreservice.services.WorkerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;
    private final CategoryRepository categoryRepository;
    private final WorkerTaskResultRepository workerTaskResultRepository;
    private final TaskRepository taskRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository, CategoryRepository categoryRepository, WorkerTaskResultRepository workerTaskResultRepository, TaskRepository taskRepository) {
        this.workerRepository = workerRepository;
        this.categoryRepository = categoryRepository;
        this.workerTaskResultRepository = workerTaskResultRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public String save(String username) {
        Worker worker = Worker.builder()
                .username(username)
                .build();
        workerRepository.save(worker);
        return worker.getId();
    }

    @Override
    public WorkerInfoResult getWorkerCategoryResults(String workerId) {
        Worker worker = workerRepository.findById(workerId)
                .orElseThrow(() -> new RuntimeException("worker not found"));

        List<Category> categories = categoryRepository.findAll();
        List<WorkerCategoryResult> results = new ArrayList<>();

        for (Category category : categories) {
            WorkerCategoryResult categoryResult = WorkerCategoryResult.builder()
                    .categoryName(category.getName())
                    .taskResults(new ArrayList<>())
                    .build();

            List<Task> tasks = taskRepository.findAllByCategory(category);
            for (Task task : tasks) {
                WorkerTaskResult taskResult = workerTaskResultRepository.findByWorkerAndTask(worker, task);
                if (taskResult != null) {
                    categoryResult.getTaskResults().add(TaskResult.builder()
                            .taskName(task.getName())
                            .score(taskResult.getScore())
                            .build());
                }
            }

            categoryResult.getTaskResults().sort(Comparator
                    .comparing(TaskResult::getScore)
                    .reversed()
            );
            results.add(categoryResult);
        }

        return WorkerInfoResult.builder()
                .username(worker.getUsername())
                .workerCategoryResults(results)
                .build();
    }

}

