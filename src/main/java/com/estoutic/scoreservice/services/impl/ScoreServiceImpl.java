package com.estoutic.scoreservice.services.impl;

import com.estoutic.scoreservice.controllers.models.SortedScoreDto;
import com.estoutic.scoreservice.controllers.models.UserScoreInfoDto;
import com.estoutic.scoreservice.database.models.UserScore;
import com.estoutic.scoreservice.database.repositories.UserScoreRepository;
import com.estoutic.scoreservice.services.ScoreService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<SortedScoreDto> getSortedFirstCategory() {
        List<UserScoreInfoDto>  allInfo = getAllInfo();

        return allInfo.stream()
                .map(user -> new SortedScoreDto(user.getId(), user.getName(), user.getFirstScore()))
                .sorted(Comparator.comparingInt(SortedScoreDto::getScore).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<SortedScoreDto> getSortedSecondCategory() {
        List<UserScoreInfoDto>  allInfo = getAllInfo();

        return allInfo.stream()
                .map(user -> new SortedScoreDto(user.getId(), user.getName(), user.getSecondScore()))
                .sorted(Comparator.comparingInt(SortedScoreDto::getScore).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<SortedScoreDto> getSortedThirdCategory() {
        List<UserScoreInfoDto>  allInfo = getAllInfo();

        return allInfo.stream()
                .map(user -> new SortedScoreDto(user.getId(), user.getName(), user.getThirdScore()))
                .sorted(Comparator.comparingInt(SortedScoreDto::getScore).reversed())
                .collect(Collectors.toList());
    }
}
