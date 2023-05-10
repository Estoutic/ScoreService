package com.estoutic.scoreservice.database.repositories.task;

import com.estoutic.scoreservice.database.models.Category;
import com.estoutic.scoreservice.database.models.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

    public List<Task> findAllByCategory(Category category);
}

