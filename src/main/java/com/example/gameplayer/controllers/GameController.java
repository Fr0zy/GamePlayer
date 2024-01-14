package com.example.gameplayer.controllers;

import com.example.gameplayer.dto.UserLoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {
    @GetMapping("/game")
    public String showGame(Model model){
        return "unitygame/index";
    }
}
