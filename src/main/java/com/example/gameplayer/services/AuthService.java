package com.example.gameplayer.services;

import com.example.gameplayer.dto.UserLoginDTO;
import com.example.gameplayer.dto.UserRegisterDTO;
import com.example.gameplayer.model.Users;
import com.example.gameplayer.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsersRepository usersRepository;

    public Long register(UserRegisterDTO userRegisterDTO){
        var userToSave = toUser(userRegisterDTO);
        var savedUser = usersRepository.save(userToSave);
        return savedUser.getId();
    }

    private static Users toUser(UserRegisterDTO userRegisterDTO) {
        return new Users(null, null, userRegisterDTO.getName(), userRegisterDTO.getEmail(), userRegisterDTO.getPassword());
    }
    public Long login(UserLoginDTO userLoginDTO){
        var user = usersRepository.findByNickname(userLoginDTO.getNickname());
        if(user.isPresent() && userLoginDTO.getPassword().equals(user.get().getPassword())){
            return user.get().getId();
        }
        return null;
    }
}
