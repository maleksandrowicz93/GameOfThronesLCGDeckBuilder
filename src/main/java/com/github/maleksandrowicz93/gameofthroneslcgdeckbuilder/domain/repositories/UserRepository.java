package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.repositories;

import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
