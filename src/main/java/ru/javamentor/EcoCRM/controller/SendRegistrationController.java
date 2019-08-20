package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.javamentor.EcoCRM.service.EmailServiceImpl;

@Controller
public class SendRegistrationController {

    @Autowired
    private EmailServiceImpl emailServiceimp;

    @GetMapping("/sendReg")
    public String SendReg(Model model) {
        String userEmail = "";
        model.addAttribute("userEmail",userEmail);
        return "sendregform";
    }
    @PostMapping("/processSendForm")
   // public String processSendForm(@RequestParam(name = "userEmail") String userEmail) {
    public String   processingSenForm(@ModelAttribute("userEmail") String userEmail) {
        System.out.println("user email is: " + userEmail);
        emailServiceimp.sendSimpleMessage(userEmail,"To target mail from form", "Hello,Volunteer! Welcome to our Service!");
        System.out.println("mailsended");
        return "admin_page";
    }
}
