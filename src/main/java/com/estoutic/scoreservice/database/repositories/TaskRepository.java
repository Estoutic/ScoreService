package com.estoutic.scoreservice.database.repositories;

import com.estoutic.scoreservice.database.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
}
