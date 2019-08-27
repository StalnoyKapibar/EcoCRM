package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.javamentor.EcoCRM.model.Authority;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.service.AuthoritiesService;
import ru.javamentor.EcoCRM.service.ProjectService;
import ru.javamentor.EcoCRM.service.UserService;

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
        //String currentUserName = auth.getName();
        List<Authority> roles = (List<Authority>) auth.getAuthorities();
        for (Authority role : roles) {
            if (role.getAuthority().contains("ROLE_ADMIN")) {
                return "redirect:/admin/manage";
            }
        }
        return "user";
    }

    @GetMapping("/admin/manage")
    public String showAllUsers(Model model) {
        List<User> usersList = userService.getAll();
        model.addAttribute("usersList", usersList);
        return "/admin/manage";
    }

    @GetMapping("/user")
    public String showUser(Model model, Authentication authentication) {
        Long id = ((User)authentication.getPrincipal()).getId();
        model.addAttribute("projects", projectService.getPersonProjectDto(id));
        return "person_page_projects";
    }
    @GetMapping("/userinfo")
    public String showUserInfo(Model model) {

        return "userinfo";
    }
    @GetMapping("/useredit")
    public String userEdit() {
        return "edituserform";
    }

    @GetMapping("/get_petition")
    public String getPetitionPage() {
        return "petition_page";
    }


}
