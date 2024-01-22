package com.example.gameplayer.commands;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class UsersCommand {

    private Long id;
    private String nickname;
    private String email;
    private String password;
}
