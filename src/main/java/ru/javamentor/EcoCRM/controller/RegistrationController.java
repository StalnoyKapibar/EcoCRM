package ru.javamentor.EcoCRM.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.javamentor.EcoCRM.model.Authority;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.service.AuthoritiesService;
import ru.javamentor.EcoCRM.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("registration")
public class RegistrationController {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserService userService;

    @Autowired
    AuthoritiesService authoritiesService;

    @GetMapping("/new")
    public String registrationForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "registration/registration-form";
    }

    @PostMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        List<Authority> roles = new ArrayList<>();
        roles.add(authoritiesService.get(2));      //set user_role
        user.setAuthorities(roles);
        userService.insert(user);

        return "admin_page";
    }

}
