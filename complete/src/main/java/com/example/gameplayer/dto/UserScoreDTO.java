package com.example.gameplayer.dto;

import lombok.Value;

@Value
public class UserScoreDTO {

    Long id;
    String nickname;
    Long score;
}
