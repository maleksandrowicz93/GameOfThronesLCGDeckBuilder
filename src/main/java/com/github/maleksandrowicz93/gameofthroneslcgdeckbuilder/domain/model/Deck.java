package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "decks")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String name;
    private LocalDateTime created;
    private LocalDateTime updated;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @PrePersist
    private void createdDeckTime() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    private void updatedDeckTime() {
        updated = LocalDateTime.now();
    }

    @ManyToMany
    private List<Card> cards = new ArrayList<>();

}
