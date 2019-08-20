package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin/usersList")
public class UsersListController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String showAllUsers(Model model) {
          List<User> listusers = userService.getAll();
            System.out.println(listusers.toString());
          model.addAttribute("listusers", listusers);
//        ModelAndView modelAndView = new ModelAndView("user");
//        modelAndView.addObject("user.name", user);
//        modelAndView.addObject("user.mail", user);
//        modelAndView.addObject("user.status", user);
//        return modelAndView;

        System.out.println("controller ready");
        return "users";
    }
}
