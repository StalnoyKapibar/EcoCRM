package ru.javamentor.EcoCRM.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.EcoCRM.dto.stepDTO.StepDTO;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;
import ru.javamentor.EcoCRM.service.ProjectService;
import ru.javamentor.EcoCRM.service.StepServiceImpl;
import ru.javamentor.EcoCRM.service.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectRestController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private StepServiceImpl stepService;

    @GetMapping
    public Map<StepNumber, List<Project>> getProjectsBySteps() {
        Map<StepNumber, List<Project>> r = projectService.getListByStepInProgress();
        return r;
    }
    //todo
    @GetMapping("/selfOnly")
    public Map<StepNumber, List<Project>> getProjectsByStepsSelfOnly() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = ((UserDetails)principal).getUsername();
        User currentUser = userService.getUserByEmail(email);
        Map<StepNumber, List<Project>> r = projectService.getListByStepInProgress();
        for (Map.Entry<StepNumber,List<Project>> entry : r.entrySet()) {
            entry.getValue().removeIf(project -> project.getManager().equals(currentUser));
        }
        return r;
    }

    @RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
    public Project getProject(@PathVariable("projectId") Long projectId, Model model) {
        return projectService.get(projectId);
    }

    @RequestMapping(value = "/{id}/stepdto", method = RequestMethod.GET)
    public StepDTO getStepDTO(@PathVariable("id") Long id, @RequestParam(value = "stepnumber") StepNumber stepNumber) {
        return stepService.getStepDTO(id, stepNumber);
    }
}
