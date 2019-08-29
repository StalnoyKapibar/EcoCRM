package ru.javamentor.EcoCRM.controller.rest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javamentor.EcoCRM.model.Point;


@Controller
@RequestMapping("/")
public class PointsRestController {

    @GetMapping("/youtube")
    public String getProjectsByStepsSelfOnly() {
        return "my_upload";
    }
}
