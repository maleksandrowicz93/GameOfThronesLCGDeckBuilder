package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "cards")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String code;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private boolean isUnique;
    @Column(nullable = false)
    private boolean isLoyal;
    @Column(nullable = false)
    private String faction;
    @Column(nullable = false)
    private int cost;
    @Column(nullable = false)
    private int strength;
    private String description;
    @Column(nullable = false)
    private int deckLimit;

    @ManyToOne
    @JoinColumn(name = "set_id", nullable = false)
    private CardSet cardSet;

//    @ElementCollection(targetClass = Icons.class)
    private Icons icons;

//    @ElementCollection(targetClass = PlotStats.class)
    private PlotStats plotStats;

    @ElementCollection
    @Column(name = "trait")
    private List<String> traits = new ArrayList<>();

}
