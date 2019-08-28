package ru.javamentor.EcoCRM.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/request")
public class RequestRestController {



    @Autowired
    RequestService requestService;

    @Autowired
    UserService userService;
    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/add/{project_id}", method = RequestMethod.GET)
    public String addRequest(@PathVariable("project_id") Long projectId) {
       requestService.addRequestToAccept(projectId);
        return "/projects/all";
    }
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Request> getAllRequests() {
        List<Request> requestList = requestService.getAll();
        return requestList;
    }
    @RequestMapping(value = "/getMy", method = RequestMethod.GET)
    public List<Request> getMyRequests() {
        List<Request> requestList = requestService.getAll();
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        requestList.removeIf(request -> !request.getManagerId().equals(currentUser.getId()));
        return requestList;
    }
    @RequestMapping(value = "/accept/{id}", method = RequestMethod.GET)
    public String acceptRequest(@PathVariable Long id) {
        requestService.acceptRequest(id);
        return "/userinfo";
    }
    @RequestMapping(value = "/decline/{id}", method = RequestMethod.GET)
    public String declineRequest(@PathVariable Long id) {
        requestService.delete(requestService.get(id));
        return "/userinfo";
    }


}
