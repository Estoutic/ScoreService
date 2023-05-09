package com.estoutic.scoreservice.services.impl;

import com.estoutic.scoreservice.database.models.Worker;
import com.estoutic.scoreservice.database.repositories.WorkerRepository;
import com.estoutic.scoreservice.services.WorkerService;
import org.springframework.stereotype.Service;

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
}
