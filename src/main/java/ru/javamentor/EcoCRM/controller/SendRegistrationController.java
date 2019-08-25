package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.javamentor.EcoCRM.model.Token;
import ru.javamentor.EcoCRM.service.EmailServiceImpl;
import ru.javamentor.EcoCRM.service.SchedulerService;
import ru.javamentor.EcoCRM.service.UserService;
import ru.javamentor.EcoCRM.service.token.service.TokenService;

import java.util.UUID;


@Controller
public class SendRegistrationController {

    @Autowired
    private EmailServiceImpl emailServiceImpl;

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @Autowired
    SchedulerService schedulerService;

    @Autowired
    EmailServiceImpl getEmailServiceImpl;

    @Value("${host.name}")
    String hostName;
    @GetMapping("/admin/sendReg")
    public String SendReg(Model model) {
        String userEmail = "";
        model.addAttribute("userEmail",userEmail);
        return "/admin/sendregform";
    }

    @PostMapping("/admin/processSendForm")
    public String   processingSendForm(@ModelAttribute("userEmail") String userEmail) {

        String code = UUID.randomUUID().toString();
        tokenService.insert(new Token(userEmail, code));

        String message = "Hello,Volunteer! Welcome to our Service!\n Your link for registration: " +
                "\nhttp://"+hostName+"/registration/new/?code=" + code;

        getEmailServiceImpl.sendSimpleMessage(userEmail,"To target mail from form", message);
        return "redirect:/admin/manage";
    }
}
