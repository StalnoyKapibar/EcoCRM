package ru.javamentor.EcoCRM.controller.rest;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.service.EmailService;
import ru.javamentor.EcoCRM.service.UserService;

import java.util.Locale;
import java.util.Random;

@RestController
public class RecoveryRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private Faker faker = new Faker(new Locale("ru"));

    @PostMapping("/recovery")
    public String recoverUser(@RequestParam("email") String email){
        User userToRecover = userService.getUserByEmail(email);
        if (userToRecover != null) {
            String newPass = faker.superhero().name().replaceAll(" ", "") + (new Random()).nextInt(322);
            userToRecover.setPassword(bCryptPasswordEncoder.encode(newPass));
            userService.update(userToRecover);
            emailService.sendSimpleMessage(email, "Восстановление пароля ECO CRM", "Ваш новый пароль для доступа в систему: " + newPass);
            return "recovered";
        } else {
            return "error";
        }

    }

}
