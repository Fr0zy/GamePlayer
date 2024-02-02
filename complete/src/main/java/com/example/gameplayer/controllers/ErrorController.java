package com.example.gameplayer.controllers;

import com.example.gameplayer.dto.UserLoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("/error")
    public String showErrorForm(Model model){
        return "LoginPage/LoginError/login-error";
    }
}
