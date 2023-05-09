package com.estoutic.scoreservice.services.impl;

import com.estoutic.scoreservice.controllers.models.UserScoreInfoDto;
import com.estoutic.scoreservice.database.models.UserScore;
import com.estoutic.scoreservice.database.repositories.UserScoreRepository;
import com.estoutic.scoreservice.services.ScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    public final UserScoreRepository userScoreRepository;

    public ScoreServiceImpl(UserScoreRepository userScoreRepository) {
        this.userScoreRepository = userScoreRepository;
    }

    @Override
    public void saveScoreInfo(UserScoreInfoDto userScoreInfoDto) {
        UserScore userScore = new UserScore(userScoreInfoDto);
        userScoreRepository.save(userScore);
    }

    @Override
    public List<UserScoreInfoDto> getAllInfo() {
        return userScoreRepository.findAll().stream().map(UserScoreInfoDto::new).toList();
    }
}
