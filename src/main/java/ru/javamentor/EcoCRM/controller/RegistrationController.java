package ru.javamentor.EcoCRM.controller;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.javamentor.EcoCRM.model.Authority;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.service.AuthoritiesService;
import ru.javamentor.EcoCRM.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("registration")
public class RegistrationController {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserService userService;

    @Autowired
    AuthoritiesService authoritiesService;

    //TODO PROPERTY
    private final String CLIEND_ID = "7104443";
    private final String CLIENT_SECRET = "dW9deofq9rWqvBoiLkoJ";

    @GetMapping("/new")
    public String registrationForm() {
        return "registration/registration-form";
    }




    @GetMapping("/usercode")
    public String getCode(@RequestParam(name = "code") String code,Model model) throws IOException, JSONException {
        System.out.println(code);
        String urlForToken = "https://oauth.vk.com/access_token?client_id="+CLIEND_ID+"&client_secret="+CLIENT_SECRET+"&redirect_uri=http://localhost:8080/registration/usercode&code="+code;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(urlForToken, String.class);
        JSONObject jsonReq = new JSONObject(response.getBody());
        String accesToken = jsonReq.getString("access_token");
        String userId = jsonReq.getString("user_id");
        String urlForInfo = "https://api.vk.com/method/users.get?user_ids="+ userId +"&fields=photo_50&access_token=" + accesToken +"&v=5.101";
        User user = new User();
        user.setEmail("bastard_operator");
        model.addAttribute("user", user);
        model.addAttribute("urlForInfo",urlForInfo);
        return "registration/registration-form-with-vk";
    }

}
