package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.javamentor.EcoCRM.model.Token;
import ru.javamentor.EcoCRM.service.EmailServiceImpl;
import ru.javamentor.EcoCRM.service.TokenService;
import ru.javamentor.EcoCRM.service.UserService;

import java.security.SecureRandom;

@Controller
public class SendRegistrationController {

    @Autowired
    private EmailServiceImpl emailServiceImpl;

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${host.name}")
    String hostName;
    @GetMapping("/sendReg")
    public String SendReg(Model model) {
        String userEmail = "";
        model.addAttribute("userEmail",userEmail);
        return "sendregform";
    }

    @GetMapping("/processSendForm")
    public String processingSendForm(@RequestParam("userEmail") String userEmail) {
        String token = bCryptPasswordEncoder.encode(userEmail);
        tokenService.insert(new Token(userEmail, token));
        System.out.println("result String: " + token);
        String message = "Hello,Volunteer! Welcome to our Service!\n Your link for registration: " +
                "\nhttp://"+hostName+"/registration/new/?email=" + userEmail + "&token=" + token;
        emailServiceImpl.sendSimpleMessage(userEmail,"To target mail from form", message);
        System.out.println("Send Successful!");
        return "admin_page";
    }
}
