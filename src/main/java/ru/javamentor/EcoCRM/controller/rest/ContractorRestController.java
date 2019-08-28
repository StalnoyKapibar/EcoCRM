package ru.javamentor.EcoCRM.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.EcoCRM.model.Contractor;
import ru.javamentor.EcoCRM.service.ContractorService;

import java.util.List;

@RestController
@RequestMapping("/api/contractor")
public class ContractorRestController {

    @Autowired
    ContractorService contractorService;

    @GetMapping(value = "/{id}")
    public Contractor getContractor(@PathVariable("id") Long id) {
        return contractorService.get(id);
    }

    @GetMapping("/all")
    public List<Contractor> getAll() {
        return contractorService.getAll();
    }

    @PostMapping("/new")
    public ResponseEntity addContractor(@RequestBody Contractor contractor) {
        contractorService.insert(contractor);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/{id}/comment")
    public ResponseEntity addComment(@PathVariable Long id, @RequestBody String comment) {
        contractorService.saveComment(id, comment);
        return new ResponseEntity(HttpStatus.OK);
    }
}
