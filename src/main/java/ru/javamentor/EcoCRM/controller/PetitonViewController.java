package ru.javamentor.EcoCRM.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/petition" )
public class PetitonViewController {

    @GetMapping
    public String pettion(){
        return "petition";
    }

}
