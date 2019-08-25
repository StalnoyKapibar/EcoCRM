package ru.javamentor.EcoCRM.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.EcoCRM.dto.PetitionDTO;
import ru.javamentor.EcoCRM.model.Petition;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.model.embedded.Status;
import ru.javamentor.EcoCRM.service.EmailServiceImpl;
import ru.javamentor.EcoCRM.service.PetitionService;
import ru.javamentor.EcoCRM.service.ProjectService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/petition")
public class PetitionRestController {

    @Autowired
    private PetitionService petitionService;

    @Autowired
    private EmailServiceImpl emailServiceimp;

    @Autowired
    private ProjectService projectService;

    @Value("${path.to.mail}")
    String pathToLetter;

    @PostMapping
    public void getSearchUserProfiles(@ModelAttribute("petition") Petition petition) throws MessagingException {

        LocalDate data = LocalDate.now();
        petition.setData(data);
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
    }

    @PutMapping(value = "/addPetitionUser")
    public void addUserPetition(@RequestParam(value = "id") long id, Authentication authentication){
        Petition petition = petitionService.get(id);
        User user = (User) authentication.getPrincipal();
        petition.setStatus(Status.IN_PROGRESS);
        petition.getUserPetition().add(user);
        petitionService.update(petition);
    }

    @RequestMapping(value = "/get_by_project_id/{projectid}", method = RequestMethod.GET)
    public Petition getPetitionByProjectId(@PathVariable Long projectid, Model model) {
        Project project = projectService.get(projectid);
        return project.getPetition();
    }

    @GetMapping("/getAllAdminPetitionWithUserRest")
    public List<PetitionDTO> getAllPetitonWithUser(){
        List<PetitionDTO> petitionDTOList = petitionService.getAllPetitionForAdmin();
        return petitionDTOList;

    }
}


