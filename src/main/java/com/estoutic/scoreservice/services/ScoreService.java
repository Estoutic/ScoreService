package com.estoutic.scoreservice.services;

import com.estoutic.scoreservice.controllers.models.UserScoreInfoDto;

public interface ScoreService {

    void saveScoreInfo(UserScoreInfoDto userScoreInfoDto);
}
