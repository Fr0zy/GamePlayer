package com.example.gameplayer.services;

import com.example.gameplayer.dto.StoreScoreDto;
import com.example.gameplayer.dto.UserScoreDTO;
import com.example.gameplayer.model.Score;
import com.example.gameplayer.repositories.ScoreRepository;
import com.example.gameplayer.repositories.UsersRepository;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class UserScoreService {
    private final Logger logger = LoggerFactory.getLogger(UserScoreService.class);

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
                .sorted(Comparator.comparing(UserScoreDTO::getScore).reversed())
                .toList();
    }

    public void storeScore(StoreScoreDto storeScoreDto) {
        logger.info("Querying user with nickname: {}", storeScoreDto.getNickname());
        var user = usersRepository.findByNickname(storeScoreDto.getNickname());
        if (user.isEmpty()) {
            logger.error("User with nickname: {} not found", storeScoreDto.getNickname());
            throw new RuntimeException("User not found");
        }

        var actualUser = user.get();
        var scoreToSave = scoreRepository.findByUsersId(actualUser.getId())
                .map(score -> updateScore(storeScoreDto, score))
                .orElseGet(() -> new Score(storeScoreDto.getScore(), actualUser));

        logger.info("Saving score: {}", scoreToSave);
        var savedScore = scoreRepository.save(scoreToSave);
        logger.info("Score: {} saved", savedScore);
    }

    private static Score updateScore(StoreScoreDto storeScoreDto, Score score) {
        if (storeScoreDto.getScore() > score.getScore()) {
            score.setScore(storeScoreDto.getScore());
        }
        return score;
    }
}
