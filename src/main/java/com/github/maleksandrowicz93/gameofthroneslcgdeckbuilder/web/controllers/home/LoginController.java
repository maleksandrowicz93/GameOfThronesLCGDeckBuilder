package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.web.controllers.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String prepareLoginPage() {
        return "home/login-page";
    }

}
