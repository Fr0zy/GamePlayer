package com.example.gameplayer.repositories;

import com.example.gameplayer.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<Users, Long> {

    Optional<Users> findByNickname(String nickname);
}
