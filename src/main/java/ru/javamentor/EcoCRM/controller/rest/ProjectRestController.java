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
import ru.javamentor.EcoCRM.model.Request;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;
import ru.javamentor.EcoCRM.service.ProjectService;
import ru.javamentor.EcoCRM.service.RequestService;
import ru.javamentor.EcoCRM.service.StepServiceImpl;
import ru.javamentor.EcoCRM.service.UserService;

import java.security.Principal;
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
    @Autowired
    RequestService requestService;

    @GetMapping("/all")
    public Map<StepNumber, List<Project>> getProjectsBySteps() {
        Map<StepNumber, List<Project>> r = projectService.getListByStepInProgress();
        return r;
    }

    @GetMapping("/selfOnly")
    public Map<StepNumber, List<Project>> getProjectsByStepsSelfOnly() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = ((UserDetails)principal).getUsername();
        User currentUser = userService.getUserByEmail(email);
        Map<StepNumber, List<Project>> r = projectService.getListByStepInProgress();
        for (Map.Entry<StepNumber,List<Project>> entry : r.entrySet()) {
            entry.getValue().removeIf(project -> !project.getManager().equals(currentUser));
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

    //Добавление заявки на участие в проекте
    @RequestMapping(value = "/request/{project_id}", method = RequestMethod.GET)
    public String addRequest(@PathVariable("project_id") Long id) {
        Project projectRequested = projectService.get(id);
        Long ManagerId = projectRequested.getManager().getId();

        User currentUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Request newRequest = new Request(currentUser.getName() + " " + currentUser.getSurname(),/*projectRequested.getPetition().getHouseArea(),currentUser.getId()*/"someaddress",currentUser.getId(),projectRequested.getId());

        User Manager = userService.get(ManagerId);
        List<Request> currentRequests = Manager.getRequestList();
        currentRequests.add(newRequest);
        requestService.insert(newRequest);
        Manager.setRequestList(currentRequests);
        userService.update(Manager);
        return "/projects/all";
    }


    @GetMapping("/manager/{id}")
    public List<Project> getProjectsWhereUserIsManager(@PathVariable("id") Long id) {
        return projectService.getProjManagerByUserId(id);
    }

    @GetMapping("/member/{id}")
    public List<Project> getProjectsWhereUserIsMember(@PathVariable("id") Long id) {
        return projectService.getProjVolunteerByUserId(id);
    }
}
