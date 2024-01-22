package com.example.gameplayer.converters;

import com.example.gameplayer.commands.UsersCommand;
import jakarta.annotation.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.example.gameplayer.model.Users;

@Component
public class UsersCommandToUsers implements Converter<UsersCommand, Users> {

    @Synchronized
    @Nullable
    @Override
    public Users convert(UsersCommand source){

        final Users users = new Users();
        users.setNickname(source.getNickname());
        users.setEmail(source.getEmail());
        users.setPassword(source.getPassword());
        return users;
    }
}
