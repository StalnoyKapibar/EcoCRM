package ru.javamentor.EcoCRM.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.javamentor.EcoCRM.model.Authority;

import java.util.List;

@Controller
public class ApplicationController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "login";
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
    public String showUser() {
        return "user";
    }
}
