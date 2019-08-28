package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;
import ru.javamentor.EcoCRM.service.ProjectService;


@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;


    @GetMapping("/all")
    public ModelAndView showProjects() {
        ModelAndView modelAndView = new ModelAndView("projects");
        modelAndView.addObject("apiHref","/api/project/all");
        return modelAndView;
    }

    @GetMapping("/selfOnly")
    public ModelAndView showSelfProjects() {
        ModelAndView modelAndView = new ModelAndView("projects");
        modelAndView.addObject("apiHref","/api/project/selfOnly");
        return modelAndView;
    }
}
