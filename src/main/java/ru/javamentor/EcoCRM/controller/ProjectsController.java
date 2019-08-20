package ru.javamentor.EcoCRM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectsController {
    @GetMapping("/admin/projects")
    public String showProjects() {
        return "/admin/projects";
    }
}
