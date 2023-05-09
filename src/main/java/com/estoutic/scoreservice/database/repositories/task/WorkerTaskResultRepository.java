package com.estoutic.scoreservice.database.repositories.task;

import com.estoutic.scoreservice.database.models.task.WorkerTaskResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerTaskResultRepository extends JpaRepository<WorkerTaskResult, String> {
}
