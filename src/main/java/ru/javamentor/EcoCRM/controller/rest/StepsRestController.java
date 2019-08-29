package ru.javamentor.EcoCRM.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.EcoCRM.model.ManagementCompany;
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
    public String getStep (@RequestParam("project_id") Long projectId){
        Step currentStep = stepService.getStepByProjectIdAndStepNumber(projectId, StepNumber.STEP_1);
        List <Task> tasks = taskService.getAllByStepId(currentStep.getId());
        return "ok";
    }


    @RequestMapping(value = "/get_by_project_id/{projectid}", method = RequestMethod.GET)
    public List<Step> adminPageEmployerToEdit(@PathVariable Long projectid) {
        return stepService.getAllByprojectId(projectid);
    }
}
