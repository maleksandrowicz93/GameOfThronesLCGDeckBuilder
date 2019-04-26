package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.web.controllers.useracc;

import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.repositories.CardSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class SetsController {

    @Autowired
    private CardSetRepository cardSetRepository;

    @GetMapping("/sets")
    public String displaySetsPage(Model model) {
        model.addAttribute("sets", cardSetRepository.findAll());
        return "useracc/sets-page";
    }

    @GetMapping("/sets/{cgbdId}")
    public String displaySetsPageWithChosenSet(@PathVariable Integer cgbdId, Model model) {
        model.addAttribute("cards", cardSetRepository.findFirstByCgbdId(cgbdId).getCards());
        return "useracc/sets-page";
    }

}
