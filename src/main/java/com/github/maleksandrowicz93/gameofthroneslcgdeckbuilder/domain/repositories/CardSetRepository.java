package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.repositories;

import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.model.Card;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.model.CardSet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardSetRepository extends JpaRepository<CardSet, Integer> {

    CardSet findFirstByCgbdId(Integer cgbdId);

}
