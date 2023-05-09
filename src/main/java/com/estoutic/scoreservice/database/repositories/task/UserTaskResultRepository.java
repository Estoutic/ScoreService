package com.estoutic.scoreservice.database.repositories.task;

import com.estoutic.scoreservice.database.models.task.UserTaskResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTaskResultRepository extends JpaRepository<UserTaskResult, String> {
}
