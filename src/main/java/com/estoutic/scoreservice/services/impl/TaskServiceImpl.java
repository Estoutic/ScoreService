package com.estoutic.scoreservice.services.impl;

import com.estoutic.scoreservice.database.models.Category;
import com.estoutic.scoreservice.database.models.Task;
import com.estoutic.scoreservice.database.repositories.CategoryRepository;
import com.estoutic.scoreservice.database.repositories.TaskRepository;
import com.estoutic.scoreservice.services.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {


    private final CategoryRepository categoryRepository;
    private final TaskRepository taskRepository;

    public TaskServiceImpl(CategoryRepository categoryRepository, TaskRepository taskRepository) {
        this.categoryRepository = categoryRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public String save(String categoryId, String taskName) {

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
}
