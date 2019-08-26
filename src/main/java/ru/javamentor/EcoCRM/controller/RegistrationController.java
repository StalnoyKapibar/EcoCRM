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
import org.springframework.web.servlet.ModelAndView;
import ru.javamentor.EcoCRM.model.Token;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.service.AuthoritiesService;
import ru.javamentor.EcoCRM.service.TokenService;
import ru.javamentor.EcoCRM.service.UserService;

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

    @Value("${host.name}")
    String hostName;
    @Value("${vk.app.id")
    private String CLIEND_ID;
    @Value("${vk.app.secret")
    private String CLIENT_SECRET;

    @GetMapping("/new")
    public String registrationForm(@RequestParam("email")String email,@RequestParam("token")String token, Model model) {
        User user = new User();
        user.setEmail(email);
        model.addAttribute("user", user);
        Token dbtoken =  tokenService.loadTokenByEmail(email);
        String tokenFromDB =dbtoken.getToken();
        if (tokenFromDB.equals(token)) {
            //tokenService.delete(dbtoken); TODO продлить время жизни и не удалять сразу
            return "registration/registration-form";
        }
        return "access-denied";
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
