package ru.javamentor.EcoCRM.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.javamentor.EcoCRM.model.ManagementCompany;
import ru.javamentor.EcoCRM.model.Photo;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.service.ImageService;
import ru.javamentor.EcoCRM.service.ManagementCompanyService;
import ru.javamentor.EcoCRM.service.PhotoService;
import ru.javamentor.EcoCRM.service.ProjectService;

import javax.imageio.ImageIO;
import javax.persistence.Convert;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

//step 2
    @PostMapping("/add_company")
    public ResponseEntity<ManagementCompany> saveManagInfo(@RequestParam(value = "projectid") Long projectId, @RequestBody ManagementCompany managementCompany) {
        String companyName = managementCompany.getName();
        Project project = projectService.get(projectId);
        if (project.getCompany()==null){
            managementCompanyService.insert(managementCompany);
            project.setCompany(managementCompanyService.get(managementCompany.getId()));
//            project.setCompany(new ManagementCompany(managementCompany.getName(), managementCompany.getInn(), managementCompany.getLink(),
//                    managementCompany.getManagerName(), managementCompany.getManagerSurname(), managementCompany.getManagerPatronymic(),
//                    managementCompany.getPhoneNumber(), managementCompany.getEmail(), managementCompany.getClock(), managementCompany.getDescription(),
//                    managementCompany.getNextContactDate()));
        }else {
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
//        if (managementCompanyService.get(projectId) == null) {
//            managementCompanyService.insert(managementCompany);
//        } else {
//            managementCompanyService.update(managementCompany);
//        }
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
        for(MultipartFile file : img){
            Photo p = new Photo(imageService.resizeImage(ImageIO.read(new ByteArrayInputStream(file.getBytes())),600,600));
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


}
