package ru.javamentor.EcoCRM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;

@Controller
@RequestMapping("/map")
public class MapController {

    @GetMapping("/")
    public String showProjects() {
        int map =3;
        return "steps/map";
    }


}
