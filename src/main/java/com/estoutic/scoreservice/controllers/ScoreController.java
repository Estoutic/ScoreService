package com.estoutic.scoreservice.controllers;

import com.estoutic.scoreservice.controllers.models.UserScoreInfoDto;
import com.estoutic.scoreservice.services.ScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {

    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping("/add")
    public void ping(@RequestBody() UserScoreInfoDto userScoreInfoDto){
        scoreService.saveScoreInfo(userScoreInfoDto);
    }

    @GetMapping("/all")
    public List<UserScoreInfoDto> getAllInfo(){
        return scoreService.getAllInfo();
    }
}
