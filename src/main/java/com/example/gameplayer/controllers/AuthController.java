package com.example.gameplayer.controllers;

import com.example.gameplayer.dto.UserLoginDTO;
import com.example.gameplayer.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class AuthController {
    private final AuthService authService;

    @GetMapping("/login")
    public String showLoginForm(Model model){
        model.addAttribute("loginForm", new UserLoginDTO());
        return "loginForm";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("loginForm") UserLoginDTO userLoginDTO) {
        var userId = authService.login(userLoginDTO);
        if (userId == null) {
            return "redirect:/error";
        }

        return "redirect:/index";
    }



}
