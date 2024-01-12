package com.example.gameplayer.services;

import com.example.gameplayer.dto.UserScoreDTO;
import com.example.gameplayer.model.Score;
import com.example.gameplayer.repositories.ScoreRepository;
import com.example.gameplayer.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class UserScoreService {
    private final UsersRepository usersRepository;
    private final ScoreRepository scoreRepository;

    public UserScoreService(UsersRepository userRepository, ScoreRepository scoreRepository) {
        this.usersRepository = userRepository;
        this.scoreRepository = scoreRepository;
    }

    public List<UserScoreDTO> getUserScores() {
        // Perform a join operation in your repository or service
        return StreamSupport.stream(scoreRepository.findAll().spliterator(), false)
                .map(score -> new UserScoreDTO(score.getUsers().getId(), score.getUsers().getNickname(),score.getScore()))
                .toList();
    }
}
