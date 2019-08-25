package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.service.AuthoritiesService;
import ru.javamentor.EcoCRM.service.ProjectService;
import ru.javamentor.EcoCRM.service.UserService;
import ru.javamentor.EcoCRM.model.Authority;

import java.util.List;

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
        return "login_user_page";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }

    @GetMapping("/")
    public String startPageRedirectRoleDepending() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = auth.getName();
        List<Authority> roles = (List<Authority>) auth.getAuthorities();
        for (Authority role : roles) {
            if (role.getAuthority().contains("ROLE_ADMIN")) {
                return "/admin/admin_page";
            }
        }
        return "user";
    }

    @GetMapping("/admin/page")
    public String showAdminPage() {
        return "/admin/admin_page";
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

}
