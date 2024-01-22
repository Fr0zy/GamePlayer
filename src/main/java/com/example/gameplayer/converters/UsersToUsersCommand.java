package com.example.gameplayer.converters;

import com.example.gameplayer.commands.UsersCommand;
import jakarta.annotation.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.example.gameplayer.model.Users;

@Component
public class UsersToUsersCommand implements Converter<Users, UsersCommand> {

    @Synchronized
    @Nullable
    @Override
    public UsersCommand convert(Users source){

        final UsersCommand command = new UsersCommand();
        command.setId(source.getId());
        command.setNickname(source.getNickname());
        command.setPassword(source.getPassword());
        command.setEmail(source.getEmail());
        return command;
    }
}