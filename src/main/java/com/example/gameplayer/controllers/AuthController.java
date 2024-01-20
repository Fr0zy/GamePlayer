package com.example.gameplayer.controllers;

import com.example.gameplayer.dto.UserLoginDTO;
import com.example.gameplayer.dto.UserRegisterDTO;
import com.example.gameplayer.services.AuthService;
import jakarta.servlet.http.HttpSession;
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
        return "LoginPage/SignIn/sign-in";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("loginForm") UserLoginDTO userLoginDTO, Model model) {
        var userId = authService.login(userLoginDTO);
        if (userId == null) {
            return "LoginPage/LoginError/login-error";
        }
        model.addAttribute("userId", userId);
        return "redirect:/index";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("registerForm", new UserRegisterDTO());
        return "LoginPage/SignUp/sign-up";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute("registerForm") UserRegisterDTO userRegisterDTO) {
        var userId = authService.register(userRegisterDTO);
        if (userId == null) {
            return "LoginPage/LoginError/login-error";
        }

        return "redirect:/login";
    }

    @GetMapping("/forgot-password")
    public String showForgotPassword(Model model){
        return "LoginPage/ForgotPassword/forgot-password";
    }
}
