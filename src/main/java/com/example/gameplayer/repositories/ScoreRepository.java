package com.example.gameplayer.repositories;

import com.example.gameplayer.model.Score;
import com.example.gameplayer.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ScoreRepository extends CrudRepository<Score, Long> {
    Optional<Score> findByUsersId(Long id);
}