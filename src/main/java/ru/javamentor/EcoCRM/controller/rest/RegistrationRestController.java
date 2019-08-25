package ru.javamentor.EcoCRM.controller.rest;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.javamentor.EcoCRM.model.Authority;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.service.AuthoritiesService;
import ru.javamentor.EcoCRM.service.ImageService;
import ru.javamentor.EcoCRM.service.UserService;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/registration")
public class RegistrationRestController {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserService userService;

    @Autowired
    AuthoritiesService authoritiesService;

    @Autowired
    @Qualifier("imageService")
    ImageService imageService;

    @Value("${host.name}")
    String hostName;

    @RequestMapping(value = "/update_image", method = RequestMethod.POST)
    public String updateImage(@RequestParam(value = "email") String email,
                              @RequestParam(value = "image") MultipartFile img) {
        User user = (User) userService.loadUserByUsername(email);
        if (img.getSize() != 0) {
            try {
                user.setPhoto(imageService.resizeImage(ImageIO.read(new ByteArrayInputStream(img.getBytes())),150,150));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else{
            try {
                user.setPhoto(imageService.resizeImage(ImageIO.read(new File("src\\main\\resources\\static\\private\\images\\avatar.png")),150,150));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        userService.update(user);
        return "/admin";
    }
    //TODO Перенести в /api/users нормально
    @PostMapping("/new")
    public String addUser(@RequestBody String userJson) throws JSONException {
        JSONObject jsonObject = new JSONObject(userJson);
        User user = new User();
        user.setName(jsonObject.getString("name"));
        user.setSurname(jsonObject.getString("surname"));
        user.setPhone(jsonObject.getString("phone"));
        user.setEmail(jsonObject.getString("email"));
        user.setLink(jsonObject.getString("link"));
        user.setProfession(jsonObject.getString("profession"));
        user.setPassword(bCryptPasswordEncoder.encode(jsonObject.getString("password")));
        user.setNotToDo(jsonObject.getString("notToDo"));
        List<Authority> roles = new ArrayList<>();
        roles.add(authoritiesService.get(2));      //set user_role
        user.setAuthorities(roles);
        userService.insert(user);
        return "/admin";
    }


}
