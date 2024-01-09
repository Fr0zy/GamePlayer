package com.example.gameplayer.repositories;

import com.example.gameplayer.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> {
}
