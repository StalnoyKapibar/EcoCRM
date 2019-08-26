package ru.javamentor.EcoCRM.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javamentor.EcoCRM.model.Contractor;
import ru.javamentor.EcoCRM.service.ContractorService;

import java.util.List;

@RestController
@RequestMapping("/api/contractor")
public class ContractorRestController {

    @Autowired
    ContractorService contractorService;

    @GetMapping("/all")
    public List<Contractor> getAll() {
        return contractorService.getAll();
    }
}
