package ru.javamentor.EcoCRM.controller;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.javamentor.EcoCRM.dao.TokenNotFoundException;
import ru.javamentor.EcoCRM.model.Authority;
import org.springframework.web.servlet.ModelAndView;
import ru.javamentor.EcoCRM.model.Token;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.service.AuthoritiesService;
import ru.javamentor.EcoCRM.service.ImageService;
import ru.javamentor.EcoCRM.service.token.service.TokenService;
import ru.javamentor.EcoCRM.service.UserService;

import javax.imageio.ImageIO;
import java.io.File;
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

    @Autowired
    TokenService tokenService;

    @Autowired
    ImageService imageService;

    @Value("${host.name}")
    String hostName;

    //TODO PROPERTY
    private final String CLIEND_ID = "7104443";
    private final String CLIENT_SECRET = "dW9deofq9rWqvBoiLkoJ";

    @GetMapping("/new")
    public String registrationForm(@RequestParam("code") String code, Model model) {

        try {
            Token dbtoken = tokenService.loadTokenByCode(code);
            User user = new User();
            user.setEmail(dbtoken.getEmail());
            model.addAttribute("user", user);
            return "registration/registration-form";

        } catch (TokenNotFoundException e) {
            System.out.println(e.getMessage());
            return "wrong-token";
        }
    }
    @PostMapping("/new")
    public String addUser(@ModelAttribute("user") User user) throws IOException {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        List<Authority> roles = new ArrayList<>();
        roles.add(authoritiesService.get(2));      //set user_role
        user.setAuthorities(roles);
        user.setPhoto(imageService.resizeImage(ImageIO.read(new File("/home/whitenoise/Документы/CRMBootCamp/EcoCRM/src/main/resources/static/private/images/avatar.png")),150,150));
        userService.insert(user);
        //user.setPhoto(imageService.resizeImage(ImageIO.read(new File("src\\main\\resources\\static\\private\\images\\avatar.png")),150,150));
        //user.setPhoto(imageService.resizeImage(ImageIO.read(new File("/home/whitenoise/Документы/CRMBootCamp/EcoCRM/src/main/resources/static/private/images/avatar.png")),150,150));
        //user.setPhoto(imageService.resizeImage(ImageIO.read(new File("/Users/aitalina/Desktop/CRM/src/main/resources/static/private/images/avatar.png")),150,150));
        return "redirect:/admin/manage";
    }
    @GetMapping("/usercode")
    public ModelAndView getCode(@RequestParam(name = "code") String code) throws JSONException {

            String urlForToken = "https://oauth.vk.com/access_token?client_id="+CLIEND_ID+"&client_secret="+CLIENT_SECRET+"&redirect_uri=http://"+hostName+"/registration/usercode&code="+code;
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity(urlForToken, String.class);
            JSONObject jsonReq = new JSONObject(response.getBody());
            String accesToken = jsonReq.getString("access_token");
            String userId = jsonReq.getString("user_id");
            String urlForInfo = "https://api.vk.com/method/users.get?user_ids="+ userId +"&fields=bdate&access_token=" + accesToken +"&v=5.101";
            ModelAndView modelAndView = new ModelAndView("registration/registration-form-with-vk");
            modelAndView.addObject("urlForInfo",urlForInfo);

            return modelAndView;
    }

}
