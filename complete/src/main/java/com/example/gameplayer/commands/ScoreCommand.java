package com.example.gameplayer.commands;

import com.example.gameplayer.model.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ScoreCommand {

    private Long id;
    private Long score;
    private Users users;
}
