package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.repositories;

import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.model.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckRepository extends JpaRepository<Deck, Integer> {
}
