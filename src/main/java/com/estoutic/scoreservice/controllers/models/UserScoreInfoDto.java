package com.estoutic.scoreservice.controllers.models;


import com.estoutic.scoreservice.database.models.UserScore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserScoreInfoDto{

    public String id;

    public String name;

    public Integer firstScore;

    public Integer secondScore;

    public Integer thirdScore;

    public UserScoreInfoDto(UserScore userScore){
        this.id = userScore.getId();
        this.name = userScore.getUsername();
        this.firstScore = userScore.getFirstScore();
        this.secondScore = userScore.getSecondScore();
        this.thirdScore = userScore.getThirdScore();
    }

}
