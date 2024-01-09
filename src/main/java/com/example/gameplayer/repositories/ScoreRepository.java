package com.example.gameplayer.repositories;

import com.example.gameplayer.model.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreRepository extends CrudRepository<Score, Long> {
}