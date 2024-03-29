package ru.javamentor.EcoCRM.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.EcoCRM.dto.CurrentUserDTO;
import ru.javamentor.EcoCRM.dto.PersonProjectDTO;
import ru.javamentor.EcoCRM.dto.UserEncoderPhotoDTO;
import ru.javamentor.EcoCRM.model.Petition;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.model.embedded.UserStatus;
import ru.javamentor.EcoCRM.service.DTOService;
import ru.javamentor.EcoCRM.service.ProjectService;
import ru.javamentor.EcoCRM.service.UserService;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private DTOService dtoService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public User getUser(@PathVariable(required = false) Long id) {
        return userService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/photo/{id}")
    public String getUserPhoto(@PathVariable(required = false) Long id) {
        return userService.get(id).getEncoderPhoto();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/photos")
    public List<String> getAllUserPhotos(@PathVariable(required = false) Long id) {
        return userService.getAllUsersPhoto();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/projects/manager/{id}")
    public List<Project> getUserProjManager(@PathVariable(required = false) Long id) {
        return projectService.getProjectsByUserId(id);
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
        userService.update(user);
        return "/admin/usersList";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/unblock")
    public String unblockUser(@RequestParam(value = "id") Long id) throws IOException {
        User user = userService.get(id);
        user.setStatus(UserStatus.ACTIVE);
        userService.update(user);
        return "/admin/usersList";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get_current_user")
    public CurrentUserDTO getCurrentUser(Principal principal){
        User user = (User) userService.loadUserByUsername(principal.getName());
        CurrentUserDTO userDTO = dtoService.convertCurrentUserToDTO(user);
        return userDTO;
    }
    @PutMapping("/update")
    public User updateUser(@RequestBody CurrentUserDTO userdto) {
        User user = dtoService.convertDTOToCurrentUser(userdto);
        userService.update(user);
        return user;
    }


    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/all/encodephotos")
    public List<UserEncoderPhotoDTO> getUsersWithEncoderPhoto() {
        return userService.getUsersWithEncoderPhoto();
    }
}
