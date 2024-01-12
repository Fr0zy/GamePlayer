package com.example.gameplayer.converters;

import com.example.gameplayer.commands.ScoreCommand;
import jakarta.annotation.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.example.gameplayer.model.Score;

@Component
public class ScoreToScoreCommand implements Converter<Score, ScoreCommand> {

    @Synchronized
    @Nullable
    @Override
    public ScoreCommand convert(Score source){

        final ScoreCommand command = new ScoreCommand();
        command.setScore(source.getScore());
        command.setUsers(source.getUsers());
        return command;
    }
}