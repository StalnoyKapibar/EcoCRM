package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin/usersList")
public class UsersListController {

    @Autowired
    private UserService userService;

    //todo
    @GetMapping("/")
    public String showAllUsers(Model model) {
          List<User> usersList = userService.getAll();
          System.out.println(usersList.toString());
          model.addAttribute("usersList", usersList);
        return "/admin/users";
    }
}
