package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.web.controllers.useracc;

import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.model.Deck;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.model.User;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.repositories.UserRepository;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.dtos.UserDTO;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.web.services.Converters;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.web.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class ManagerController {

    private UserService userService;
    private UserRepository userRepository;

    public ManagerController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/manager")
    public String displayManagerPage(Principal principal, Model model) {
        User user = userRepository.findFirstByUsername(principal.getName());
        Deck deck = userService.lastAddedDeck(user);
        model.addAttribute("lastAddedDeck", deck);
        return "useracc/manager-page";
    }



}
