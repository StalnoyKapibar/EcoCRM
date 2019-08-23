package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.Step;
import ru.javamentor.EcoCRM.model.Task;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;
import ru.javamentor.EcoCRM.service.PetitionService;
import ru.javamentor.EcoCRM.service.ProjectService;
import ru.javamentor.EcoCRM.service.StepService;
import ru.javamentor.EcoCRM.service.TaskService;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api/steps")
public class StepsRestController {

    @Autowired
    ProjectService projectService;

    @Autowired
    StepService stepService;

    @Autowired
    TaskService taskService;

    @Autowired
    PetitionService petitionService;

    @RequestMapping(value = "/step_1", method = RequestMethod.POST)
    public List<Task> getStep (@RequestParam("project_id") Long projectId){
        Step currentStep = stepService.getStepByProjectIdAndStepNumber(projectId, StepNumber.STEP_1);
        return taskService.getAllByStepId(currentStep.getId());
    }
}
