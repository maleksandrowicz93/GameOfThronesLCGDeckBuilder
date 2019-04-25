package com.github.maleksandrowicz93.gameofthroneslcgdeckbuilder.web.controllers.home;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/contact")
public class ContactPageController {

    private MailSender mailSender;

    @GetMapping
    public String displayContactPage() { return "home/contact-page"; }

//    @GetMapping
//    @ResponseBody
//    public String sendMail(@RequestParam String recipient) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(recipient);
//        message.setFrom("Kubuś puchatek");
//        message.setSubject("Test wysyłki");
//        message.setText("Jakie to wszytsko jest proste :)");
//
//        mailSender.send(message);
//        return "Wysłano";
//    }

}
