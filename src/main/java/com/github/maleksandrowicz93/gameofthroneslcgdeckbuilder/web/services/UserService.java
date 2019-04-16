package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.web.services;

import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.model.User;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.domain.repositories.UserRepository;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.dtos.RegistrationFormDTO;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.dtos.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class UserService {

    private static final Logger loger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void registerUser(RegistrationFormDTO form) {
        User user = Converters.convertToUser(form);

        loger.info("rejestracja użytkownika " + user);
        userRepository.save(user);
        loger.info("Zarejestrowany użytkownik: " + user);
    }

    public UserDTO findUser(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Nazwa użytkownika musi być podana");
        }
        Optional<User> optionalUser = userRepository.findByUsername(username);
        User user = optionalUser.orElse(null);
        if (user == null) {
            loger.debug("Nie znaleziono użytkownika dla nazwy '" + username + "'");
            return null;
        }
        loger.debug("Znaleziono użytkownika dla nazwy '" + username + "' : " + user);
        return Converters.convertToUserDTO(user);
    }
}
