package ru.javamentor.EcoCRM.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.EcoCRM.dto.PersonProjectDTO;
import ru.javamentor.EcoCRM.model.Petition;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.model.embedded.UserStatus;
import ru.javamentor.EcoCRM.service.ProjectService;
import ru.javamentor.EcoCRM.service.UserService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public User getUser(@PathVariable(required = false) Long id) {
        return userService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/photo/{id}")
    public String getUserPhoto(@PathVariable(required = false) Long id) {
        return userService.get(id).getEncoderPhoto();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/projects/manager/{id}")
    public List<Project> getUserProjManager(@PathVariable(required = false) Long id) {
        return projectService.getProjManagerByUserId(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/projects/volunteer/{id}")
    public List<Project> getUserProjVolunteer(@PathVariable(required = false) Long id) {
        return projectService.getProjVolunteerByUserId(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/projects/{id}")
    public List<PersonProjectDTO> getProject(@PathVariable(required = false) Long id) {
        return projectService.getPersonProjectDto(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/block")
    public String blockUser(@RequestParam(value = "id") Long id) {
        User user = userService.get(id);
        user.setStatus(UserStatus.BLOCKED);
        user.setEnabled();
        userService.update(user);
        return "/admin/manage";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/unblock")
    public String unblockUser(@RequestParam(value = "id") Long id) throws IOException {
        User user = userService.get(id);
        user.setStatus(UserStatus.ACTIVE);
        user.setEnabled();
        userService.update(user);
        return "/admin/manage";
    }
}
