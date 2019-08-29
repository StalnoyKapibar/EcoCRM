package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.javamentor.EcoCRM.dto.PetitionDTO;
import ru.javamentor.EcoCRM.model.Authority;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;
import ru.javamentor.EcoCRM.service.*;

import java.util.List;

@Controller
public class ApplicationController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthoritiesService authoritiesService;

    @Autowired
    StepService stepService;

    @Autowired
    ProjectService projectService;

    @Autowired
    PetitionService petitionService;

    @GetMapping("/")
    public String startPageRedirectRoleDepending() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Authority> roles = (List<Authority>) auth.getAuthorities();
        for (Authority role : roles) {
            if (role.getAuthority().contains("ROLE_ADMIN")) {
                return "redirect:/admin/usersList";
            }
        }
        return "redirect:/userinfo";
    }

    @GetMapping("/userinfo")
    public String showUserInfo(Model model) {
        return "userinfo";
    }

    @GetMapping("/user")
    public String showUser(Model model, Authentication authentication) {
        Long id = ((User) authentication.getPrincipal()).getId();
        model.addAttribute("id", id);
        return "person_page_projects";
    }

    @GetMapping("/projects")
    public ModelAndView showProjects(ModelAndView modelAndView) {
        modelAndView.addObject("stepNumber", StepNumber.values());
        modelAndView.addObject("projects", projectService.getListByStepInProgress());
        modelAndView.setViewName("/projects");
        return modelAndView;
    }

    @GetMapping("/petition")
    public String getPetition(){
        return "petition";
    }

    @GetMapping("/petition/getAllPetition")
    public String allUsers(Model model, Authentication authentication) {
        Long id = ((User) authentication.getPrincipal()).getId();
        model.addAttribute("id", id);
        return "all_petitions";
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

    @GetMapping("/project/{id}")
    public ModelAndView getProject(@PathVariable("id") Long projectId, ModelAndView modelAndView, Authentication authentication) {
        modelAndView.setViewName("project_page");
        if (!projectService.isManageProject(((User)authentication.getPrincipal()).getId(), projectId)) {
            return  new ModelAndView("access-denied", HttpStatus.FORBIDDEN);
        } else {
            StepNumber stepNumber = stepService.getProgressStepByProjectId(projectId).getStepNumber();
            modelAndView.addObject("id", projectId);
            modelAndView.addObject("stepNumber", stepNumber);
        }
            return modelAndView;
    }

    @GetMapping("/all_users")
    public String getAllUsers(Long id, Model model) {
        model.addAttribute("all", userService.getAll());
        return "all_users";
    }

    @GetMapping("/useredit")
    public String useredit() {
        return "edituserform";
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

    @GetMapping("/calendar")
    public String getCalendar() {
        return "/steps/calendar";
    }
}
