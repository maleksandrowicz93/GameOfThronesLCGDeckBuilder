package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.web.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.model.Card;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.repositories.CardRepository;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.dtos.CardSetDTO;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;


@Service
public class CardsService {

    private CardRepository cardRepository;

    public CardSetDTO.Set
    loadCardSet(String address) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(address), CardSetDTO.Set.class);
    }

    public void saveCardSetToDB(CardSetDTO.Set cardSetDTO) {
        cardSetDTO.getCards().forEach(card -> {
            Card c = Converters.convertToCard(card);
            cardRepository.save(c);
        });
    }

}