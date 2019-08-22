package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.EcoCRM.model.Petition;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.model.UserStatus;
import ru.javamentor.EcoCRM.service.ProjectService;
import ru.javamentor.EcoCRM.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UsersRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public User getUser(@PathVariable(required = false) Long id) {
        return userService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/projects/{id}")
    public List<Project> getUserProjects(@PathVariable(required = false) Long id) {
        return projectService.getProjectsByUserId(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/block")
    public String blockUser(@RequestParam(value = "id") Long id) {
        User user = userService.get(id);
        user.setStatus(UserStatus.BLOCKED);
        user.setEnabled();
        userService.update(user);
        return "/admin/usersList";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/unblock")
    public String unblockUser(@RequestParam(value = "id") Long id) throws IOException {
        User user = userService.get(id);
        user.setStatus(UserStatus.ACTIVE);
        user.setEnabled();
        userService.update(user);
        return "/admin/usersList";
    }
}