package ru.javamentor.EcoCRM.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.EcoCRM.model.ManagementCompany;
import ru.javamentor.EcoCRM.service.ManagementCompanyService;
import ru.javamentor.EcoCRM.service.ProjectService;

@RestController
@RequestMapping("/manage_company")
public class ManagementCompanyRestController {

    @Autowired
    ManagementCompanyService managementCompanyService;

    @Autowired
    ProjectService projectService;

    @PostMapping("/add")
    public ResponseEntity saveManagInfo(@RequestParam(value = "projectid") Long projectId,
                                        @RequestBody ManagementCompany managementCompany) {
        if (managementCompanyService.get(projectId) == null) {
            managementCompanyService.insert(managementCompany);
        } else {
            managementCompanyService.update(managementCompany);
        }
        return new ResponseEntity(managementCompanyService.get(projectId), HttpStatus.OK);
    }
}
