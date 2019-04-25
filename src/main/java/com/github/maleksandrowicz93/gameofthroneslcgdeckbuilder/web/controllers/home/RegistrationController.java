package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.web.controllers.home;

import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.dtos.RegistrationFormDTO;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.dtos.UserDTO;
import com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.web.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String prepareRegistrationForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationFormDTO());
        return "home/registration-page";
    }

    @PostMapping
    public String processRegistration(@Valid @ModelAttribute("registrationForm") RegistrationFormDTO form, BindingResult result) {
        if (result.hasErrors()) {
            return "home/registration-page";
        }
        if (checkPasswordEquality(form)) {
            result.rejectValue("password", null, "Hasło i powtórzone hasło są niezgodne");
        }
        if (!checkIsUserNameAvailable(form)) {
            result.rejectValue("username", null, "Nazwa użytkownika jest już zajęta");
        }
        userService.registerUser(form);
        return "redirect:index.html";
    }

    private boolean checkPasswordEquality(RegistrationFormDTO form) {
        return form.getPassword().equals(form.getConfirmedPassword());
    }

    private boolean checkIsUserNameAvailable(RegistrationFormDTO form) {
        UserDTO user = userService.findUser(form.getUsername());
        return user == null;
    }

}
