package com.example.gameplayer.controllers;

import com.example.gameplayer.dto.StoreScoreDto;
import com.example.gameplayer.services.UserScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScoreController {
    private final UserScoreService userScoreService;

    @PostMapping("/score")
    public ResponseEntity<?> storeScore(@RequestBody StoreScoreDto storeScoreDto) {
        userScoreService.storeScore(storeScoreDto);
        return ResponseEntity.ok().build();
    }
}