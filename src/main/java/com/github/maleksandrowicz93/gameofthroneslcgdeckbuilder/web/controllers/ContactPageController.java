package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class ContactPageController {

    @GetMapping
    public String displayContactPage() { return "contact-page"; }

}
