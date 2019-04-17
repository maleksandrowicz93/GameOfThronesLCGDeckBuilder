package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.repositories;

import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {
}
