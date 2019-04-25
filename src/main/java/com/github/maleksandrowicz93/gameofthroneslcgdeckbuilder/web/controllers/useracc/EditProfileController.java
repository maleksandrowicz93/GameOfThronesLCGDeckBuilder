package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.web.controllers.useracc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class EditProfileController {

    @GetMapping("/edit")
    public String displayEditProfilePage() {
        return "useracc/edit-profile-page";
    }

}
