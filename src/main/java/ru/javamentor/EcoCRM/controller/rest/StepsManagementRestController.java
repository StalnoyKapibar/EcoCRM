package ru.javamentor.EcoCRM.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.javamentor.EcoCRM.model.*;
import ru.javamentor.EcoCRM.service.*;

import javax.imageio.ImageIO;
import javax.persistence.Convert;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/manage")
public class StepsManagementRestController {

    @Autowired
    ManagementCompanyService managementCompanyService;

    @Autowired
    ProjectService projectService;

    @Autowired
    ImageService imageService;

    @Autowired
    PhotoService photoService;

    @Autowired
    CheckPointService checkPointService;

    //step 2
    @PostMapping("/add_company")
    public ResponseEntity<ManagementCompany> saveManagInfo(@RequestParam(value = "projectid") Long projectId, @RequestBody ManagementCompany managementCompany) {
        String companyName = managementCompany.getName();
        Project project = projectService.get(projectId);
        if (project.getCompany() == null) {
            managementCompanyService.insert(managementCompany);
            project.setCompany(managementCompanyService.get(managementCompany.getId()));
        } else {
            ManagementCompany updatedCompany = project.getCompany();
            updatedCompany.setName(managementCompany.getName());
            updatedCompany.setInn(managementCompany.getInn());
            updatedCompany.setLink(managementCompany.getLink());
            updatedCompany.setManagerName(managementCompany.getManagerName());
            updatedCompany.setManagerSurname(managementCompany.getManagerSurname());
            updatedCompany.setManagerPatronymic(managementCompany.getManagerPatronymic());
            updatedCompany.setPhoneNumber(managementCompany.getPhoneNumber());
            updatedCompany.setEmail(managementCompany.getEmail());
            updatedCompany.setClock(managementCompany.getClock());
            updatedCompany.setDescription(managementCompany.getDescription());
            updatedCompany.setNextContactDate(managementCompany.getNextContactDate());
        }
        projectService.update(project);
        return new ResponseEntity(managementCompanyService.get(projectId), HttpStatus.OK);
    }

    //  step 5
    @PostMapping("/add_container")
    public Long saveContainerInfo(@RequestParam(value = "projectid") Long projectId,
                                  @RequestParam(value = "image") List<MultipartFile> img,
                                  @RequestParam(value = "newContainerComment") String comment,
                                  @RequestParam(value = "newContainerDate") String date) throws IOException, ParseException {
        Project project = projectService.get(projectId);
        List<Photo> listPhoto = new ArrayList<>();
        for (MultipartFile file : img) {
            Photo p = new Photo(imageService.resizeImage(ImageIO.read(new ByteArrayInputStream(file.getBytes())), 600, 600));
            photoService.insert(p);
            listPhoto.add(p);
        }
        project.setNewContainerPhoto(listPhoto);
        project.setNewContainerComment(comment);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date formatedDate = dateFormat.parse(date);
        project.setNewContainerDate(formatedDate);
        projectService.update(project);
        return projectId;
    }

    //step 8
    @PostMapping("/add_check_point/{id}")
    public ResponseEntity saveCheckPointInfo(@PathVariable Long id,
                                             @RequestParam(value = "name") String name,
                                             @RequestParam(value = "description") String description,
                                             @RequestParam(value = "date") String date) throws ParseException {

        Project project = projectService.get(id);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-M-d");
        Date formatedDate = dateFormat.parse(date);
        CheckPoint cp = new CheckPoint(name, description, formatedDate);
        checkPointService.insert(cp);
        project.getCheckPoints().add(cp);
        projectService.update(project);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all_checked_dates/{projectId}")
    public List<CheckPoint> getAllCheckPoints(@PathVariable(required = false) Long projectId) {
        List<CheckPoint> cp = checkPointService.getAllCheckPoints(projectId);
        return cp;
    }

    @GetMapping("/check_point/{id}")
    public CheckPoint getCheckPoint(@PathVariable(required = false) Long id) {
        CheckPoint cp = checkPointService.get(id);
        return cp;
    }
}
