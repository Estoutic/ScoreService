package com.estoutic.scoreservice.database.models;

import com.estoutic.scoreservice.controllers.models.UserScoreInfoDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class UserScore {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 64, updatable = false, nullable = false)
    private String id;

    private String username;

    private int firstScore;

    private int secondScore;

    private int thirdScore;

    public UserScore(UserScoreInfoDto userScoreInfoDto) {
        this.username = userScoreInfoDto.getName();
        this.firstScore = userScoreInfoDto.getFirstScore();
        this.secondScore = userScoreInfoDto.getSecondScore();
        this.thirdScore = userScoreInfoDto.getThirdScore();
    }

}
