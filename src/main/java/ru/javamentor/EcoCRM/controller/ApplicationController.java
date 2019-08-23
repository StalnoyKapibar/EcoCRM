package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.service.AuthoritiesService;
import ru.javamentor.EcoCRM.service.ProjectService;
import ru.javamentor.EcoCRM.service.UserService;

@Controller
public class ApplicationController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthoritiesService authoritiesService;

    @Autowired
    ProjectService projectService;

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
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
    public String showUser(Model model, Authentication authentication) {
        Long id = ((User)authentication.getPrincipal()).getId();
        model.addAttribute("projects", projectService.getPersonProjectDto(id));
        return "person_page_projects";
    }

}
