package ru.javamentor.EcoCRM.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javamentor.EcoCRM.dto.Step3DTO;
import ru.javamentor.EcoCRM.service.StepServiceImpl;

@RestController
@RequestMapping("/api/step")
public class StepRestController {

    @Autowired
    private StepServiceImpl stepService;

}
