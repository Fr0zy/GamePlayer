package com.example.gameplayer.controllers;

import com.example.gameplayer.services.UserScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class UsersController {
    private final UserScoreService userScoreService;

    @RequestMapping(value = {"/index"})
    public String getUsersAndScore(Model model){
        model.addAttribute("userScores", userScoreService.getUserScores());
        return "index";
    }
}