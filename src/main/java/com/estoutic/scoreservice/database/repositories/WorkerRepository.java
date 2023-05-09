package com.estoutic.scoreservice.database.repositories;

import com.estoutic.scoreservice.database.models.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, String> {
}
