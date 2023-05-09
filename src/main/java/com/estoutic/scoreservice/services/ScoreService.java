package com.estoutic.scoreservice.services;

import com.estoutic.scoreservice.controllers.models.UserScoreInfoDto;

import java.util.List;

public interface ScoreService {

    void saveScoreInfo(UserScoreInfoDto userScoreInfoDto);

    List<UserScoreInfoDto> getAllInfo();
}
