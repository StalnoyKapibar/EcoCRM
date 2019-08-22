package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.EcoCRM.model.Petition;
import ru.javamentor.EcoCRM.service.EmailServiceImpl;
import ru.javamentor.EcoCRM.service.PetitionService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;


//todo naming
@RestController
@RequestMapping("/api/petition")
public class PetitionRestController {

    @Autowired
    private PetitionService petitionService;

    @Autowired
    private EmailServiceImpl emailServiceimp;

    @Value("${path.to.mail}")
    String pathToLetter;

    @PostMapping
    public void getSearchUserProfiles(@RequestBody Petition petition) throws MessagingException {
        petitionService.insert(petition);

        MimeMessage mimeMessage = emailServiceimp.emailSender.createMimeMessage();
        boolean multipart = true;
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, multipart,"utf-8");

        String content = "";
        StringBuilder  stringBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(pathToLetter));
            String str;
            while ((str = in.readLine()) != null) {
                stringBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        content = stringBuilder.toString();
        mimeMessage.setContent(content,"text/html; charset=utf-8");
        helper.setTo(petition.getEmail());
        this.emailServiceimp.emailSender.send(mimeMessage);

            //TODO
        // emailServiceimp.sendSimpleMessage(petition.getEmail(),content,content);

    }

    @RequestMapping (value = "/test", method = RequestMethod.POST)
    public String testMethod(@RequestBody String str){
        String dfgas = str;
        return str;
    }

}


