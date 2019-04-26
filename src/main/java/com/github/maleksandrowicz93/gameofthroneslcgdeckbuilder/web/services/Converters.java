package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.web.services;

import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.model.*;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.dtos.CardSetDTO;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.dtos.RegistrationFormDTO;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.dtos.UserDTO;

import java.util.ArrayList;

public class Converters {

    public static User convertToUser(RegistrationFormDTO form) {
        User user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        return user;
    }

    public static UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        return userDTO;
    }

    public static CardSet convertToCardSet(CardSetDTO.Set cardSetDTO) {
        CardSet cardSet = new CardSet();
        cardSet.setCgbdId(cardSetDTO.getCgdbId());
        cardSet.setCode(cardSetDTO.getCode());
        cardSet.setName(cardSetDTO.getName());
        cardSet.setReleaseDate(cardSetDTO.getReleaseDate());
        cardSet.setCards(new ArrayList<>());
        return cardSet;
    }

    public static Card convertToCard(CardSetDTO.Card cardDTO) {
        Card card = new Card();
        card.setCode(cardDTO.getCode());
        card.setCost(cardDTO.getCost());
        card.setDeckLimit(cardDTO.getDeckLimit());
        card.setDescription(cardDTO.getText());
        card.setFaction(cardDTO.getFaction());
        card.setName(cardDTO.getName());
        card.setStrength(cardDTO.getStrength());
        card.setTraits(cardDTO.getTraits());
        if (cardDTO.getPlotStats()!=null) {
            card.setPlotStats(new PlotStats(cardDTO.getPlotStats().getIncome(), cardDTO.getPlotStats().getInitiative(),
                    cardDTO.getPlotStats().getClaim(), cardDTO.getPlotStats().getReserve()));
        }
        if (cardDTO.getIcons()!=null) {
            card.setIcons(new Icons(cardDTO.getIcons().getMilitary(),
                    cardDTO.getIcons().getIntrigue(), cardDTO.getIcons().getPower()));
        }
        card.setIsLoyal(cardDTO.getLoyal());
        card.setIsUnique(cardDTO.getUnique());
        card.setType(cardDTO.getType());
        return card;
    }

}
