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
import org.springframework.web.servlet.ModelAndView;
import ru.javamentor.EcoCRM.model.Authority;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.service.AuthoritiesService;
import ru.javamentor.EcoCRM.service.UserService;

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
    public final String CLIEND_ID = "7104443";
    public final String CLIENT_SECRET = "dW9deofq9rWqvBoiLkoJ";

    @GetMapping("/new")
    public String registrationForm(@RequestParam("email")String email,@RequestParam("token")String token, Model model) {
        System.out.println("EMAIL PARAMETER:" + email);
        System.out.println("TOKEN PARAMETER:" + token);
        User user = new User();
        model.addAttribute("user", user);

        return "registration/registration-form";
    }


    @PostMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        List<Authority> roles = new ArrayList<>();
        roles.add(authoritiesService.get(2));      //set user_role
        user.setAuthorities(roles);
        userService.insert(user);

        return "admin_page";
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
        String urlForInfo = "https://api.vk.com/method/users.get?user_ids="+ userId +"&fields=bdate&access_token=" + accesToken +"&v=5.101";
        User user = new User();
        user.setEmail("bastard_operator");
        model.addAttribute("user", user);
        model.addAttribute("urlForInfo",urlForInfo);
        return "registration/registration-form-with-vk";
    }

}
