package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.javamentor.EcoCRM.dto.PetitionDTO;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;
import ru.javamentor.EcoCRM.service.PetitionService;
import ru.javamentor.EcoCRM.service.ProjectService;
import ru.javamentor.EcoCRM.service.StepService;
import ru.javamentor.EcoCRM.service.UserService;

import java.util.List;

@Controller
public class ApplicationController {

    @Autowired
    private UserService userService;

    @Autowired
    StepService stepService;

    @Autowired
    ProjectService projectService;

    @Autowired
    PetitionService petitionService;

    @GetMapping("/")
    public String getPersonProjects(Model model, Authentication authentication) {
        Long id = ((User)authentication.getPrincipal()).getId();
        model.addAttribute("projects", projectService.getPersonProjectDto(id));
        return "person_page_projects";
    }

    @GetMapping("/user")
    public String showUser(Model model, Authentication authentication) {
        Long id = ((User)authentication.getPrincipal()).getId();
        model.addAttribute("projects", projectService.getPersonProjectDto(id));
        return "person_page_projects";
    }

    @RequestMapping(value = "/steps/{projectid}", method = RequestMethod.GET)
    public String adminPageEmployerToEdit(@PathVariable Long projectid, Model model) {
        model.addAttribute("projectid", projectid);
        model.addAttribute("step_6_tasks", stepService.getAllByprojectId(projectid));
        return "steps/steps_h";
    }

    @GetMapping("/projects")
    public ModelAndView showProjects(ModelAndView modelAndView) {
        modelAndView.addObject("stepNumber", StepNumber.values());
        modelAndView.addObject("projects", projectService.getListByStepInProgress());
        modelAndView.setViewName("admin/projects");
        return modelAndView;
    }

    @GetMapping("/petition")
    public String getPetition(){
        return "petition";
    }

    @GetMapping("/petition/getAllPetition")
    public ModelAndView allUsers() {
        List<PetitionDTO> petitionDTOList = petitionService.getAllPetition();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("petitions");
        modelAndView.addObject("petitionList", petitionDTOList);
        return modelAndView;
    }

    @GetMapping("/petition/getAllAdminPetitionWithUser")
    public String getAllPetitionWithUser() {
        return "petitionWithUserForAdmin";
    }

    @GetMapping("/recovery")
    public String recoveryPage() {
        return "login/recovery";
    }

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "login/login_user_page";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }

    @GetMapping("/admin/page")
    public String showAdminPage() {
        return "admin_page";
    }

    @GetMapping("/get_petition")
    public String getPetitionPage() {
        return "petition_page";
    }

    @GetMapping("/project/{id}")
    public String getProject(@PathVariable("id") Long id, Model model) {
        StepNumber stepNumber = stepService.getProgressStepByProjectId(id).getStepNumber();
        model.addAttribute("id", id);
        model.addAttribute("stepNumber", stepNumber);
        return "project_page";
    }

    @GetMapping("/all_users")
    public String getAllUsers(Long id, Model model) {
        model.addAttribute("all", userService.getAll());
        return "all_users";
    }

    @GetMapping("/users_list")
    public String showAllUsers(Model model) {
        List<User> usersList = userService.getAll();
        model.addAttribute("usersList", usersList);
        return "/admin/users";
    }

    @GetMapping("/test")
    public String getTest() {
        return "test";
    }

}
