package com.example.gameplayer.controllers;

import com.example.gameplayer.dto.UserLoginDTO;
import com.example.gameplayer.services.UserScoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {

    private UserScoreService userScoreService;

    @GetMapping("/game")
    public String showGame(Model model){
        return "unitygame/index";
    }
}
