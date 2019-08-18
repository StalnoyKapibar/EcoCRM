package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.StepNumber;

@Service
public class ProjectService {

    @Autowired
    StepService stepService;

    public void addProject(Project project) {
        for (StepNumber step : StepNumber.values()) {
            stepService.addStep(step, project);
        }
    }
}
