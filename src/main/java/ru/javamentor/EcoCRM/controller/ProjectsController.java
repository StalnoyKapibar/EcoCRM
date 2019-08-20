package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.embedded.Status;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;
import ru.javamentor.EcoCRM.service.ProjectService;

import java.util.List;
import java.util.Map;

@Controller
public class ProjectsController {
    @Autowired
    private ProjectService projectService;
    @GetMapping("/admin/projects")
    public ModelAndView showProjects(ModelAndView modelAndView) {
        return modelAndView;
    }

    @PostMapping("/admin/projects")
    public void getTestList() {
//        List<Map<Project, StepNumber>> projectList = projectService.getListByStepInProgress(StepNumber.STEP_1, Status.IN_PROGRESS);
    }
}
