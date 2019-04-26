package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.web.controllers.useracc;

import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.model.Card;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.model.Deck;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.repositories.CardRepository;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.repositories.CardSetRepository;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.repositories.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class AddDeckController {

    @Autowired
    private CardSetRepository cardSetRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private DeckRepository deckRepository;

    private Deck deck = new Deck();
    private List<Card> cards = new ArrayList<>();

    @GetMapping("/add")
    public String displayAddDeckPage(Model model) {
        model.addAttribute("sets", cardSetRepository.findAll());
        return "useracc/add-deck-page";
    }

    @GetMapping("/add/add/{cardCode}")
    public String addCardToDeck(@PathVariable String cardCode, Model model) {
        Card addingCard = cardRepository.findFirstByCode(cardCode);
        cards.add(addingCard);
        deck.setCards(cards);
        model.addAttribute("deck", deck);
        return "useracc/add-deck-page";
    }

    @GetMapping("/add/remove/{cardCode}")
    public String removingCartFromDeck(@PathVariable String cardCode, Model model) {
        Card removingCard = cardRepository.findFirstByCode(cardCode);
        cards.remove(removingCard);
        deck.setCards(cards);
        model.addAttribute("deck", deck);
        return "useracc/add-deck-page";
    }

    @GetMapping("/add/save")
    public String saveDeckToDB() {
        deckRepository.save(deck);
        deck = new Deck();
        cards = new ArrayList<>();
        return "useracc/manager-page";
    }

}
