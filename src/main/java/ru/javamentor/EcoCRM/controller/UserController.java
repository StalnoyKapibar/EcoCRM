package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.service.ProjectService;

@Controller
public class UserController {

//    @Autowired
//    ProjectService projectService;
//
//    @GetMapping(value = "/user_projects")
//    public String getAllProjectsByUser(Model model, Authentication authentication) {
//        Long id = ((User)authentication.getPrincipal()).getId();
//        model.addAttribute("projects", projectService.getPersonProjectDto(id));
//        return "person_page_projects";
//    }
}
