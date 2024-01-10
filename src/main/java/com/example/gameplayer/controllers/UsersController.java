package com.example.gameplayer.controllers;

import com.example.gameplayer.converters.UsersCommandToUsers;
import com.example.gameplayer.converters.UsersToUsersCommand;
import com.example.gameplayer.repositories.UsersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {
    private UsersRepository usersRepository;
    private UsersCommandToUsers usersCommandToUsers;
    private UsersToUsersCommand usersToUsersCommand;

    public UsersController(UsersRepository usersRepository, UsersCommandToUsers usersCommandToUsers, UsersToUsersCommand usersToUsersCommand){
        this.usersRepository = usersRepository;
        this.usersCommandToUsers = usersCommandToUsers;
        this.usersToUsersCommand = usersToUsersCommand;
    }

    @RequestMapping(value = {"/index"})
    public String getUsers(Model model){
        model.addAttribute("users", usersRepository.findAll());
        return "index";
    }
}