package com.estoutic.scoreservice.database.repositories.task;

import com.estoutic.scoreservice.controllers.models.TaskResult;
import com.estoutic.scoreservice.database.models.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task, String> {


}

