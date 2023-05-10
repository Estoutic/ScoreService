package com.estoutic.scoreservice.controllers;

import com.estoutic.scoreservice.controllers.models.worker_info.WorkerInfoResult;
import com.estoutic.scoreservice.services.WorkerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping("/add")
    public String addWorker(@RequestParam() String username) {
        return workerService.save(username);
    }

    @GetMapping("/{id}/scores")
    public WorkerInfoResult findAllWorkerScores(@PathVariable(name = "id") String workerId){
        return workerService.getWorkerCategoryResults(workerId);
    }
}
