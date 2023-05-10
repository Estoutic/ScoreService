package com.estoutic.scoreservice.services.impl;

import com.estoutic.scoreservice.database.models.Category;
import com.estoutic.scoreservice.database.models.Worker;
import com.estoutic.scoreservice.database.models.task.Task;
import com.estoutic.scoreservice.database.models.task.WorkerTaskResult;
import com.estoutic.scoreservice.database.repositories.CategoryRepository;
import com.estoutic.scoreservice.database.repositories.WorkerRepository;
import com.estoutic.scoreservice.database.repositories.task.TaskRepository;
import com.estoutic.scoreservice.database.repositories.task.WorkerTaskResultRepository;
import com.estoutic.scoreservice.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TaskServiceImpl implements TaskService {


    private final CategoryRepository categoryRepository;
    private final TaskRepository taskRepository;
    private final WorkerRepository workerRepository;
    private final WorkerTaskResultRepository workerTaskResultRepository;

    public TaskServiceImpl(CategoryRepository categoryRepository, TaskRepository taskRepository,
                           WorkerRepository workerRepository, WorkerTaskResultRepository workerTaskResultRepository) {
        this.categoryRepository = categoryRepository;
        this.taskRepository = taskRepository;
        this.workerRepository = workerRepository;
        this.workerTaskResultRepository = workerTaskResultRepository;
    }

    @Override
    public String saveTask(String categoryId, String taskName) {

        Category category = categoryRepository.findById(categoryId).orElse(null);
        if(category == null){
            return null;
        }
        Task task = Task.builder()
                .name(taskName)
                .category(category)
                .build();
        taskRepository.save(task);

        return task.getId();
    }

    @Override
    public String saveUserTaskResult(String taskId, String workerId, int score) {
        Task task = taskRepository.findById(taskId).orElse(null);
        if(task == null){
            return null;
        }
        Worker worker = workerRepository.findById(workerId).orElse(null);
        if(worker == null){
            return null;
        }
        for(WorkerTaskResult workerTaskResult : worker.getTaskResults()){
            if(Objects.equals(workerTaskResult.getTask().getId(), taskId)){
                throw new RuntimeException("result already exist");
            }
        }
        WorkerTaskResult workerTaskResult = WorkerTaskResult.builder()
                .task(task)
                .worker(worker)
                .score(score)
                .build();
        task.addTaskResult(workerTaskResult);

        workerTaskResultRepository.save(workerTaskResult);
        taskRepository.save(task);
        return workerTaskResult.getId();
    }
}
