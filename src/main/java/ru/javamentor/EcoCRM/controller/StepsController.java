package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

@Controller
public class StepsController {

    @Autowired
    ProjectService projectService;

    @Autowired
    StepService stepService;

    @Autowired
    TaskService taskService;

    @Autowired
    PetitionService petitionService;

    @RequestMapping(value = "/steps/{projectid}", method = RequestMethod.GET)
    public String adminPageEmployerToEdit(@PathVariable Long projectid, Model model) {
////        stepService.putProgressStatusToFirstStep();//todo когда 1й step будет по умолчанию in_progress удалить этот метод;
//        Project currentProject = projectService.get(projectid);
//        Step stepinProgress = stepService.getProgressStepByProjectId(currentProject.getId());
//        model.addAttribute("steps", stepService.getAllByprojectId(currentProject.getId()));
//        if (stepinProgress.getStepNumber() == StepNumber.STEP_1) {
//            model.addAttribute("petition", currentProject.getPetition());
//        }
//        if (stepinProgress.getStepNumber() == StepNumber.STEP_2) {
//            ManagementCompany company = currentProject.getManagementCompany();
//            if (company == null) {
//                company = new ManagementCompany();
//            }
//            model.addAttribute("mencompany", company);
//        }
//        model.addAttribute("stepnumber", stepinProgress.getStepNumber());
        model.addAttribute("projectid", projectid);
        model.addAttribute("step_6_tasks", stepService.getAllByprojectId(projectid));
//        List<Task> tasksInProgress = taskService.getAllByStepId(stepinProgress.getId());
//        model.addAttribute("tasks", tasksInProgress);

        return "steps/steps_h";
    }

}
