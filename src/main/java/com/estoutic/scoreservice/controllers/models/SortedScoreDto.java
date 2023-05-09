package com.estoutic.scoreservice.controllers.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortedScoreDto {

    public String id;

    public String userName;

    public int score;

    public SortedScoreDto(String id, String userName, int score){
        this.id = id;
        this.userName = userName;
        this.score = score;
    }
}
