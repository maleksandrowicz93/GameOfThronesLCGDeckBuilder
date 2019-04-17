package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sets")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cgbdId;
    @Column(nullable = false, unique = true)
    private String code;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String releaseDate;

    @OneToMany(mappedBy = "cardSet")
    private List<Card> cards = new ArrayList<>();

}
