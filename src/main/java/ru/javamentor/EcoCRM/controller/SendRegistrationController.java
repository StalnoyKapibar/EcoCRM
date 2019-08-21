package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.javamentor.EcoCRM.model.Token;
import ru.javamentor.EcoCRM.service.EmailServiceImpl;
import ru.javamentor.EcoCRM.service.UserService;

import java.security.SecureRandom;

@Controller
public class SendRegistrationController {

    @Autowired
    private EmailServiceImpl emailServiceimp;

    @Autowired
    UserService userService;

    @GetMapping("/sendReg")
    public String SendReg(Model model) {
        String userEmail = "";
        model.addAttribute("userEmail",userEmail);
        return "sendregform";
    }
    @PostMapping("/processSendForm")
    public String   processingSendForm(@ModelAttribute("userEmail") String userEmail) {

        Token token = new Token();
        token.setEmail(userEmail);



        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        String gentoken = bytes.toString();

        token.setToken(gentoken);



//        String message = "Hello,Volunteer! Welcome to our Service!\n Your link for registration: " +
//                "\nhttp://localhost:8080/registration/new";
//        emailServiceimp.sendSimpleMessage(userEmail,"To target mail from form", message);
//        System.out.println("Send Sucessfull!");


        return "admin_page";
    }
}
