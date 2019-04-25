package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.web.controllers.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/decks")
public class DecksPageController {

    @GetMapping
    public String displayDecksPAge() {return "home/decks-page"; }

}
