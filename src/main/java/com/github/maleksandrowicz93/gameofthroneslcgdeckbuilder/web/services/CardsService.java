package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.web.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.model.Card;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.model.CardSet;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.repositories.CardRepository;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.repositories.CardSetRepository;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.dtos.CardSetDTO;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.web.controllers.admin.SaveCardSetController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;


@Service
public class CardsService {

    public static final Logger logger = LoggerFactory.getLogger(SaveCardSetController.class);

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private CardSetRepository cardSetRepository;

    public CardSetDTO.Set
    loadCardSet(String address) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(address), CardSetDTO.Set.class);
    }

    public void saveCardSetToDB(CardSetDTO.Set cardSetDTO) {
        CardSet cardSet = Converters.convertToCardSet(cardSetDTO); //konwertuje DTO do card setu
        logger.info(cardSet.getCode());
        Integer id = cardSet.getId(); //pobieram id card setu
        logger.info("id = " + id);
        logger.info("set nr = " + cardSet.getCgbdId());
        logger.info("exist = " + cardSetRepository.existsById(id));
        if (cardSetRepository.existsById(id)) { //sprawdzam czy kart set istnieje
            cardSetRepository.deleteAllCardFromSet(id); //jeśli tak, usuwam z niego wszytskie karty
        } else {
            cardSetRepository.save(cardSet); //jeśli nie, tworzę set
        }
        cardSetDTO.getCards().forEach(card -> { //dla każdej karty z DTOsa
            Card c = Converters.convertToCard(card); //konwertuję ją na zwykłą kartę
            c.setCardSet(cardSet); //przypisuje do karty set
            cardRepository.save(c); // zapisuję kartę
        });
    }

}