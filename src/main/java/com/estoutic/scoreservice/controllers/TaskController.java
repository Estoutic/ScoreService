package com.estoutic.scoreservice.controllers;

import com.estoutic.scoreservice.services.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/{id}/add")
    public String addTask(@PathVariable(name = "id") String id, @RequestParam() String taskName){
        return taskService.save(id,taskName);
    }
}
