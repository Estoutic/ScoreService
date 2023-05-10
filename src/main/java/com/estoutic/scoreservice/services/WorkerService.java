package com.estoutic.scoreservice.services;

import com.estoutic.scoreservice.controllers.models.worker_info.WorkerInfoResult;

public interface WorkerService {

    String save(String username);

    WorkerInfoResult getWorkerCategoryResults(String workerId);
}
