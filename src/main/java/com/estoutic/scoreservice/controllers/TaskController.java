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
        return taskService.saveTask(id,taskName);
    }

    @PostMapping("result/{id}/add")
    public String addTaskResult(@PathVariable(name = "id") String id,
                                @RequestParam() String workerId,
                                @RequestParam() int score){
        System.out.println(score);
        return taskService.saveUserTaskResult(id,workerId,score);
    }
}
