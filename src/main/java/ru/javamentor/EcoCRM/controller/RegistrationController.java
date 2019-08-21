package ru.javamentor.EcoCRM.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
        user.setEmail("bastard_operator");
        model.addAttribute("user", user);

        return "registration-form";
    }

    @PostMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {
        user.setEmail("bastard_operator");

       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       List<Authority> baseauthorities = authoritiesService.getAll();
        for (Authority role : baseauthorities ) {
            System.out.println("BASE ROLE : " + role.getAuthority());
        }




        System.out.println("Encoded Password" + user.getPassword());
//        List<Authority> authorities = new ArrayList();
//        Authority roleadmin = new Authority("ROLE_ADMIN");
//        Authority roleuser = new Authority("ROLE_USER");
//        authorities.add(roleadmin);
//        authorities.add(roleuser);

       // user.setAuthorities(authorities);


        userService.insert(user);
        System.out.println("users password: "+ user.getPassword());
        System.out.println("users email: "  + user.getEmail());
        System.out.println("USER LOADED TO DATABASE!!!");

        return "admin_page";
    }

}
