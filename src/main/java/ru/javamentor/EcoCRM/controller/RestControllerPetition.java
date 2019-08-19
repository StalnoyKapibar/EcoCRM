package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javamentor.EcoCRM.model.Petition;
import ru.javamentor.EcoCRM.service.EmailServiceImpl;
import ru.javamentor.EcoCRM.service.PetitionService;

@RestController
@RequestMapping("/api/petition")
public class RestControllerPetition {

    @Autowired
    private PetitionService petitionService;

    @Autowired
    private EmailServiceImpl emailServiceimp;

    @PostMapping
    public void getSearchUserProfiles(@RequestBody Petition petition){
        petitionService.insert(petition);
        if (petition.getEmail() != null){
            emailServiceimp.sendSimpleMessage(petition.getEmail(), petition.getContactInformation(), petition.getStatusHome());
        }
    }
}


