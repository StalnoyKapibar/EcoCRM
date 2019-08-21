package ru.javamentor.EcoCRM.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import ru.javamentor.EcoCRM.model.User;

import java.io.IOException;

@Controller
@RequestMapping("/registration")
public class VkController {

    public final String CLIEND_ID = "7104443";
    public final String CLIENT_SECRET = "dW9deofq9rWqvBoiLkoJ";
    //https://oauth.vk.com/authorize?client_id=7104443&display=page&redirect_uri=http://localhost:8080/registration/usercode&response_type=code&v=5.101
    //https://oauth.vk.com/access_token?client_id=7104443&client_secret=dW9deofq9rWqvBoiLkoJ&redirect_uri=http://localhost:8080/registration/usercode&code=215fdc498869d46968;
    @GetMapping("/")
    public String getPrincipal(){
        return "registration/reg-principal";
    }
    @GetMapping("/usercode")
    public ModelAndView getCode(@RequestParam(name = "code") String code) throws IOException, JSONException {
        System.out.println(code);
        String urlForToken = "https://oauth.vk.com/access_token?client_id="+CLIEND_ID+"&client_secret="+CLIENT_SECRET+"&redirect_uri=http://localhost:8080/registration/usercode&code="+code;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(urlForToken, String.class);
        JSONObject jsonReq = new JSONObject(response.getBody());
        String accesToken = jsonReq.getString("access_token");
        String userId = jsonReq.getString("user_id");

        String urlForInfo = "https://api.vk.com/method/users.get?user_ids="+ userId +"&fields=bdate&access_token=" + accesToken +"&v=5.101";
        System.out.println("token : " + accesToken);

        ResponseEntity<String> responseWithInfo = restTemplate.getForEntity(urlForToken, String.class);
        jsonReq = new JSONObject(responseWithInfo.getBody());

        String firstName = jsonReq.getString("first_name");
        System.out.println(firstName);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration/reg-form");
        User newUser = new User();
        //TODO set fields
        modelAndView.addObject("user",newUser);
        return modelAndView;
    }
    @GetMapping("/test")
    public String getToken(){

        return "user";
    }
    //https://oauth.vk.com/access_token?client_id=7104443&client_secret=dW9deofq9rWqvBoiLkoJ&redirect_uri=localhost:8080/registration/token&code=aaec818b61f2fe2782
    ////secret key = ByHezan5CRKoEp4XyXay
}