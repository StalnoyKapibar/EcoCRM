package ru.javamentor.EcoCRM.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.javamentor.EcoCRM.dto.PetitionDTO;
import ru.javamentor.EcoCRM.service.PetitionService;

import java.util.List;

@Controller
@RequestMapping("/petition" )
public class PetitonViewController {

    @Autowired
    private PetitionService petitionService;

    @GetMapping
    public String pettion(){
        return "petition";
    }

    @GetMapping("/getAllPetition")
    public ModelAndView allUsers() {
        List<PetitionDTO> petitionDTOList = petitionService.getAllPetition();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("petitions");
        modelAndView.addObject("petitionList", petitionDTOList);
        return modelAndView;
    }

}
