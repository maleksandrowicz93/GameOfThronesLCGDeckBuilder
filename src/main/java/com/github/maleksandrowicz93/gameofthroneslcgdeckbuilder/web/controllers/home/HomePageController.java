package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.web.controllers.home;

import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.dtos.UserDTO;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class HomePageController {

    @Autowired
    private UserService service;

    public HomePageController(UserService service) {
        this.service = service;
    }

    @GetMapping("/user")
    @ResponseBody
    public UserDTO prepareHomePage(Principal principal) {
        return service.findUser(principal.getName());
    }

    @GetMapping("/")
    public String displayHomePage() {
        return "home/home-page";
    }

}
