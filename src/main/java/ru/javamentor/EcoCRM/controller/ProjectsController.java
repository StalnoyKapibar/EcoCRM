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
        Map<StepNumber, List<Project>> allProjects = projectService.getListByStepInProgress();
        //TODO
        modelAndView.addObject("firstStepProjects", allProjects.get(StepNumber.STEP_1));
        modelAndView.addObject("secondStepProjects", allProjects.get(StepNumber.STEP_2));
        modelAndView.addObject("thirdStepProjects", allProjects.get(StepNumber.STEP_3));
        modelAndView.addObject("fourthStepProjects", allProjects.get(StepNumber.STEP_4));
        modelAndView.addObject("fifthStepProjects", allProjects.get(StepNumber.STEP_5));
        modelAndView.addObject("sixthStepProjects", allProjects.get(StepNumber.STEP_6));
        modelAndView.addObject("seventhStepProjects", allProjects.get(StepNumber.STEP_7));
        modelAndView.addObject("eighthStepProjects", allProjects.get(StepNumber.STEP_8));
        modelAndView.setViewName("admin/projects");
        return modelAndView;
    }

    @PostMapping("/projects")
    public void getTestList() {
        projectService.getListByStepInProgress();
    }
}
