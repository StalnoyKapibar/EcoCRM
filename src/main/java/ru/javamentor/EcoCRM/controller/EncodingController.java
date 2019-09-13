package ru.javamentor.EcoCRM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("encoding")
public class EncodingController {

        @GetMapping("/1")
        public String showFirstPage() {
            return "task_1";
        }
        @GetMapping("/4")
        public String showFourthPage() {
            return "task_4";
        }

}
