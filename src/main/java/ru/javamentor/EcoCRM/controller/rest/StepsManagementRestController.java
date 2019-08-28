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
        if (managementCompanyService.get(projectId) == null) {
            managementCompanyService.insert(managementCompany);
        } else {
            managementCompanyService.update(managementCompany);
        }
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

    //step 8
    @PostMapping("/add_check_point")
    public Long saveCheckPointInfo(@RequestParam(value = "projectid") Long projectid,
                                  @RequestParam(value = "name") String name,
                                  @RequestParam(value = "description") String description,
                                  @RequestParam(value = "date") String date) throws ParseException {

        Project project = projectService.get(projectid);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date formatedDate = dateFormat.parse(date);
        CheckPoint cp = new CheckPoint(name, description, formatedDate);
        checkPointService.insert(cp);
        project.getCheckPoints().add(cp);
        projectService.update(project);
        return projectid;
    }

    @PostMapping("/add_check_point_comment")
    public Long saveCheckPointInfo(@RequestParam(value = "checkpointid") Long checkPointId,
                                   @RequestParam(value = "comment") String comment) {
        CheckPoint checkPoint = checkPointService.getCheckPointById(checkPointId);
        Comment cpComment = new Comment(comment, new Date());
        checkPoint.setComment(cpComment);
        checkPointService.update(checkPoint);
        return checkPointId;
    }
}
