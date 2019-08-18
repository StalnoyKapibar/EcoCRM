package ru.javamentor.EcoCRM;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {


    @GetMapping(value = "/test")
    public String TestAuth() {



        return "";
    }
}