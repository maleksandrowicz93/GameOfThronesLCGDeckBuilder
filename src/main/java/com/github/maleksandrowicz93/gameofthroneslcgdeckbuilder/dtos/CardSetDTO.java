package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.dtos;

import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.model.CardSet;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class CardSetDTO {

    @Getter @Setter @Data
    public static class Set {

        private Integer cgdbId;
        private String code;
        private String name;
        private String releaseDate;
        private List<Card> cards;
    }

    @Getter @Setter @Data
    public static class Card {

        private String code;
        private String type;
        private String name;
        private String faction;
        private Integer cost;
        private Integer strength;
        private Boolean loyal;
        private Boolean unique;
        private CardSet cardSet;
        private PlotStats plotStats;
        private Icons icons;
        private List<String> traits;
        private String text;
        private Integer deckLimit;
    }

    @Getter @Setter @Data
    public static class PlotStats {

        private Integer income;
        private Integer initiative;
        private Integer claim;
        private Integer reserve;
    }

    @Getter @Setter @Data
    public static class Icons {

        private Boolean military;
        private Boolean intrigue;
        private Boolean power;
    }

}
