package com.example.gameplayer.converters;

import com.example.gameplayer.commands.ScoreCommand;
import jakarta.annotation.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.example.gameplayer.model.Score;

@Component
public class ScoreCommandToScore implements Converter<ScoreCommand, Score> {

    @Synchronized
    @Nullable
    @Override
    public Score convert(ScoreCommand source){

        final Score score = new Score();
        score.setScore(source.getScore());
        score.setUsers(source.getUsers());
        return score;
    }
}