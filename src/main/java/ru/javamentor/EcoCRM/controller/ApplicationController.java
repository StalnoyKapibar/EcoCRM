package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.javamentor.EcoCRM.service.AuthoritiesService;
import ru.javamentor.EcoCRM.service.UserService;

@Controller
public class ApplicationController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthoritiesService authoritiesService;

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        System.out.println("Controller ready!");
        return "login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/admin/page")
    public String showAdminPage() {
        return "admin_page";
    }

    @GetMapping("/user")
    public String showUser() {
        return "user";
    }
}
