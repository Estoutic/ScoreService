package com.estoutic.scoreservice.database.repositories.task;

import com.estoutic.scoreservice.database.models.Worker;
import com.estoutic.scoreservice.database.models.task.Task;
import com.estoutic.scoreservice.database.models.task.WorkerTaskResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerTaskResultRepository extends JpaRepository<WorkerTaskResult, String> {

    public List<WorkerTaskResult>  findAllByWorker(Worker worker);

    List<WorkerTaskResult> findByTaskIn(List<Task> taskList);
}
