package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.web.services;

import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.model.Deck;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.model.User;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.repositories.UserRepository;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.dtos.RegistrationFormDTO;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.dtos.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void registerUser(RegistrationFormDTO form) {
        User user = Converters.convertToUser(form);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        logger.info("rejestracja użytkownika " + user);
        userRepository.save(user);
        logger.info("Zarejestrowany użytkownik: " + user);
    }

    public UserDTO findUser(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Nazwa użytkownika musi być podana");
        }
        Optional<User> optionalUser = userRepository.findByUsername(username);
        User user = optionalUser.orElse(null);
        if (user == null) {
            logger.debug("Nie znaleziono użytkownika dla nazwy '" + username + "'");
            return null;
        }
        logger.debug("Znaleziono użytkownika dla nazwy '" + username + "' : " + user);
        return Converters.convertToUserDTO(user);
    }

    public Deck lastAddedDeck(User user) {
        List<Deck> decks = user.getDecks();
        if (decks.size() == 0) {
            return null;
        }
        return decks.get(decks.size()-1);
    }
}
