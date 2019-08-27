package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.service.UserService;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin/usersList")
    public String showAllUsers(Model model) {
        List<User> usersList = userService.getAll();
        model.addAttribute("usersList", usersList);
        return "/admin/users";
    }
}
