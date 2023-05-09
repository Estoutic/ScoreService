package com.estoutic.scoreservice.services.impl;

import com.estoutic.scoreservice.database.models.Category;
import com.estoutic.scoreservice.database.models.Worker;
import com.estoutic.scoreservice.database.models.task.Task;
import com.estoutic.scoreservice.database.models.task.UserTaskResult;
import com.estoutic.scoreservice.database.repositories.CategoryRepository;
import com.estoutic.scoreservice.database.repositories.WorkerRepository;
import com.estoutic.scoreservice.database.repositories.task.TaskRepository;
import com.estoutic.scoreservice.database.repositories.task.UserTaskResultRepository;
import com.estoutic.scoreservice.services.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {


    private final CategoryRepository categoryRepository;
    private final TaskRepository taskRepository;
    private final WorkerRepository workerRepository;
    private final UserTaskResultRepository userTaskResultRepository;

    public TaskServiceImpl(CategoryRepository categoryRepository, TaskRepository taskRepository,
                           WorkerRepository workerRepository, UserTaskResultRepository userTaskResultRepository) {
        this.categoryRepository = categoryRepository;
        this.taskRepository = taskRepository;
        this.workerRepository = workerRepository;
        this.userTaskResultRepository = userTaskResultRepository;
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
    public String saveUserTaskResult(String taskId, String userId, int score) {
        Task task = taskRepository.findById(taskId).orElse(null);
        if(task == null){
            return null;
        }
        Worker worker = workerRepository.findById(userId).orElse(null);
        if(worker == null){
            return null;
        }
        UserTaskResult userTaskResult = UserTaskResult.builder()
                .task(task)
                .worker(worker)
                .score(score)
                .build();
        userTaskResultRepository.save(userTaskResult);
        return userTaskResult.getId();
    }
}
