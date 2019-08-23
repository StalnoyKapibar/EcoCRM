package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;
import ru.javamentor.EcoCRM.service.ProjectService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class ProjectsController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public ModelAndView showProjects(ModelAndView modelAndView) {
        modelAndView.addObject("stepNumber", StepNumber.values());
        modelAndView.addObject("projects", projectService.getListByStepInProgress());
        modelAndView.setViewName("admin/projects");
        return modelAndView;
    }

    @PostMapping("/projects")
    public void getTestList() {
        projectService.getListByStepInProgress();
    }
}
