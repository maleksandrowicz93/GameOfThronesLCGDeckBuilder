package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.web.controllers.admin;

import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.dtos.CardSetDTO;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.web.services.CardsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class SaveCardSetController {

    private CardsService cardsService;

    @GetMapping
    @ResponseBody
    public String adminPage() {
        return "admin page";
    }

    @GetMapping("/{cgbdId}")
    @ResponseBody
    public String saveCardSetToDB(@PathVariable String cgbdId) {
        String path = "/home/mati/Pulpit/prework/GameOfThronesLCGDeckBuilder/src/main/resources/static/json/" + cgbdId + ".json";
        try {
            CardSetDTO.Set set = cardsService.loadCardSet(path);
            cardsService.saveCardSetToDB(set);
            return "Set o Id = " + cgbdId + " zostal dodany";
        } catch (IOException e) {
            return "Plik nie istnieje";
        }
    }

}
