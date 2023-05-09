package com.estoutic.scoreservice.services;

import com.estoutic.scoreservice.controllers.models.SortedScoreDto;
import com.estoutic.scoreservice.controllers.models.UserScoreInfoDto;

import java.util.List;

public interface ScoreService {

    void saveScoreInfo(UserScoreInfoDto userScoreInfoDto);

    List<UserScoreInfoDto> getAllInfo();

    List<SortedScoreDto> getSortedFirstCategory();

    List<SortedScoreDto> getSortedSecondCategory();

    List<SortedScoreDto> getSortedThirdCategory();

}
