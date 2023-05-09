package com.estoutic.scoreservice.database.repositories.task;

import com.estoutic.scoreservice.database.models.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
}
