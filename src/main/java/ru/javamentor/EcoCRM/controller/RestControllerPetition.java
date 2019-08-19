package ru.javamentor.EcoCRM.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javamentor.EcoCRM.model.Petition;

@RestController
@RequestMapping("/api/petition")
public class RestControllerPetition {

    @PostMapping
    public void getSearchUserProfiles(@RequestBody Petition petition){
        petition.getSeparateCollection();
        petition.getContactInformation();
        String a = petition.getEmail();
    }
}
