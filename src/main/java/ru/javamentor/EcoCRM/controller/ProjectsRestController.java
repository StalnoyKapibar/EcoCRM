package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;
import ru.javamentor.EcoCRM.service.ProjectService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/projects")
public class ProjectsRestController {
    @Autowired
    private ProjectService projectService;
    @GetMapping
    public Map<StepNumber, List<Project>> getProjectsBySteps() {
        Map<StepNumber, List<Project>> r = projectService.getListByStepInProgress();
        return r;
    }
    @GetMapping("/selfOnly")
    public Map<StepNumber, List<Project>> getProjectsByStepsSelfOnly() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = ((UserDetails)principal).getUsername();
        userService.getUserByEmail(email);
        return userService.getUserByEmail(email).getId();
        Map<StepNumber, List<Project>> r = projectService.getListByStepInProgress();
        for (Map.Entry<StepNumber,List<Project>> entry : r.entrySet()) {
            for(Project x : entry.getValue()){
                x.getManager();
            }
        }
        return r;
    }
}
