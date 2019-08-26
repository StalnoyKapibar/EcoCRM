package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;
import ru.javamentor.EcoCRM.service.AuthoritiesService;
import ru.javamentor.EcoCRM.service.ProjectService;
import ru.javamentor.EcoCRM.service.StepService;
import ru.javamentor.EcoCRM.service.UserService;

@Controller
public class ApplicationController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthoritiesService authoritiesService;

    @Autowired
    ProjectService projectService;
    @GetMapping("/recovery")
    public String recoveryPage() {
        return "login/recovery";
    }

    @Autowired
    StepService stepService;

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "login/login_user_page";
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

    @GetMapping("/get_petition")
    public String getPetitionPage() {
        return "petition_page";
    }

    @GetMapping("/project/{id}")
    public String getProject(@PathVariable("id") Long id, Model model) {
        StepNumber stepNumber = stepService.getProgressStepByProjectId(id).getStepNumber();
        model.addAttribute("id", id);
        model.addAttribute("stepNumber", stepNumber);
        return "project_page";
    }

}
