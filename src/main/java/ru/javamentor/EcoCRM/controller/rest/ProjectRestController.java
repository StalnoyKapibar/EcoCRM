package ru.javamentor.EcoCRM.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/project")
public class ProjectRestController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public List<Project> getAllByUser(@PathVariable("id") Long id) {
        return projectService.getProjectsByUserId(id);
    }
}
