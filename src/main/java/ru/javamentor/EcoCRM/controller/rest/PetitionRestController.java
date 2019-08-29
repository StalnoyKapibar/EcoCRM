package ru.javamentor.EcoCRM.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import ru.javamentor.EcoCRM.dto.PetitionDTO;
import ru.javamentor.EcoCRM.model.Petition;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.User;
import ru.javamentor.EcoCRM.model.embedded.Status;
import ru.javamentor.EcoCRM.service.*;

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
    private EmailService emailService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Value("${path.to.mail}")
    String pathToLetter;

    @PostMapping
    public ResponseEntity<String> getSearchUserProfiles(@RequestBody Petition petition) throws MessagingException {
        LocalDate data = LocalDate.now();
        petition.setData(data);
        petitionService.insert(petition);
        MimeMessage mimeMessage = emailService.getEmailSender().createMimeMessage();
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
        this.emailService.getEmailSender().send(mimeMessage);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("{}");
    }

    @PutMapping(value = "/addPetitionUser")
    public void addUserPetition(@RequestParam(value = "id") Long id, Authentication authentication){
        User user = (User) authentication.getPrincipal();
        petitionService.addUserPetition(id, user);
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

    @PostMapping("/approvedByAdministrator")
    public void approvedByAdministrator(@RequestParam(value = "id") Long id, @RequestParam(value = "idp") long idp){
        User manager = userService.get(id);
        Petition petition = petitionService.get(idp);
        petition.setStatus(Status.DONE);
        petitionService.update(petition);
        Project project = new Project(manager,petition);
        projectService.insert(project);
    }

    @PostMapping("/update")
    @ResponseBody
    public void updatePetition(@RequestBody Petition petition,
                               @RequestParam (value = "projectId") Long projectId){
        Project project = projectService.get(projectId);
        Petition updatedPetition = project.getPetition();
        updatedPetition.setUserName(petition.getUserName());
        updatedPetition.setEmail(petition.getEmail());
        updatedPetition.setContactInformation(petition.getContactInformation());
        updatedPetition.setPetitionerType(petition.getPetitionerType());
        updatedPetition.setActivityType(petition.getActivityType());
        List<String> rowTypes = petition.getTypeOfRawMaterial();
        updatedPetition.setTypeOfRawMaterial(rowTypes);
        updatedPetition.setAddressHome(petition.getAddressHome());
        String district = petition.getHouseDistrict();
        updatedPetition.setHouseDistrict(district);
        updatedPetition.setFlatsCount(petition.getFlatsCount());
        updatedPetition.setManagementCompanyType(petition.getManagementCompanyType());
        updatedPetition.setAvailableCouncil(petition.getAvailableCouncil());
        updatedPetition.setManagementOrganizationRelation(petition.getManagementOrganizationRelation());
        updatedPetition.setManagementCompanyContacts(petition.getManagementCompanyContacts());
        updatedPetition.setAdditionalInformation(petition.getAdditionalInformation());
        String containerAveleble= petition.getContainerAvailable();
        updatedPetition.setContainerAvailable(containerAveleble);
        updatedPetition.setContainerSize(petition.getContainerSize());
        updatedPetition.setContainerOwner(petition.getContainerOwner());
        updatedPetition.setGarbageAvailable(petition.getGarbageAvailable());
        updatedPetition.setExportGarbage(petition.getExportGarbage());
        projectService.update(project);
    }

    @GetMapping("/all")
    public List<PetitionDTO> getAllPetitionsWithStatusToDo() {
        return petitionService.getAllPetition();
    }

    @GetMapping("/{id}")
    public Petition getById(@PathVariable("id") Long id) {
        return petitionService.get(id);
    }
}


