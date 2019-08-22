package ru.javamentor.EcoCRM.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.service.ProjectService;
import ru.javamentor.EcoCRM.service.StepService;

@Controller
public class StepsController {

    @Autowired
    ProjectService projectService;

    @Autowired
    StepService stepService;

    @RequestMapping(value = "/steps/{projectid}", method = RequestMethod.GET)
    public String adminPageEmployerToEdit(@PathVariable Long projectid, Model model) {
//        stepService.putProgressStatusToFirstStep();//todo когда 1й step будет по умолчанию in_progress удалить этот метод;
        Project currentProject = projectService.get(projectid);
        stepService.getAllByprojectId(currentProject.getId());
        model.addAttribute("steps", stepService.getAllByprojectId(currentProject.getId()));
        return "steps/steps_h";
    }

}
