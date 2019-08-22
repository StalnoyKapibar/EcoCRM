package ru.javamentor.EcoCRM.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/steps")
public class StepsRestController {

    @RequestMapping(value = "/getTasks", method = RequestMethod.POST)
    public ResponseEntity getTasks(@RequestParam("step_number") StepNumber stepNumber,
                                       @RequestParam("project_id") Long projectId) {

        return new ResponseEntity(HttpStatus.OK);
    }
}
