package com.estoutic.scoreservice.services.impl;

import com.estoutic.scoreservice.controllers.models.CategoryResult;
import com.estoutic.scoreservice.controllers.models.TaskResult;
import com.estoutic.scoreservice.database.models.Category;
import com.estoutic.scoreservice.database.models.Worker;
import com.estoutic.scoreservice.database.models.task.Task;
import com.estoutic.scoreservice.database.models.task.WorkerTaskResult;
import com.estoutic.scoreservice.database.repositories.WorkerRepository;
import com.estoutic.scoreservice.services.WorkerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
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
    public String getWorkerResults(String workerId) {
        return null;
//        List<Task> tasks = category.getTasks();
//        List<TaskResult> taskResults = new ArrayList<>();
//
//        for (Task task : tasks) {
//            String taskId = task.getId();
//            String taskName = task.getName();
//            Map<String, Integer> workerToScore = new HashMap<>();
//
//            for (WorkerTaskResult workerResult : task.getTaskResults()) {
//                String workerName = workerResult.getWorker().getUsername();
//                int score = workerResult.getScore();
//                if (workerToScore.containsKey(workerName)) {
//                    workerToScore.put(workerName, workerToScore.get(workerName) + score);
//                } else {
//                    workerToScore.put(workerName, score);
//                }
//            }
//
//            taskResults.add(new TaskResult(taskId, taskName, workerToScore));
//        }
//
//        return new CategoryResult(category.getName(), taskResults);
    }
}
