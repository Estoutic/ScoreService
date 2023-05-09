package com.estoutic.scoreservice.database.repositories;

import com.estoutic.scoreservice.database.models.UserScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserScoreRepository extends JpaRepository<UserScore, String> {
}
