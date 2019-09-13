package ru.javamentor.EcoCRM.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.javamentor.EcoCRM.model.Token;
import ru.javamentor.EcoCRM.service.EmailService;
import ru.javamentor.EcoCRM.service.TokenService;
import ru.javamentor.EcoCRM.service.UserService;

@RestController
public class SendRegistrationRestController {

    @Autowired
    private EmailService emailService;

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${host.name}")
    String hostName;

    @GetMapping("/processSendForm")
    public String processingSendForm(@RequestParam("userEmail") String userEmail) {
        if(userService.getUserByEmail(userEmail) == null) {
            String token = bCryptPasswordEncoder.encode(userEmail);
            tokenService.insert(new Token(userEmail, token));
            System.out.println(tokenService.loadTokenByEmail(userEmail));
            String message = "Здравствуй, Волонтер!\n Для регистрации необходимо перейти по ссылке: " +
                    "\nhttp://" + hostName + "/registration/new/?email=" + userEmail + "&token=" + token;
            emailService.sendSimpleMessage(userEmail, "Регистрация в ECO", message);
            return "/admin/usersList";
        } else {
            return "Already is user";
        }

    }
}
