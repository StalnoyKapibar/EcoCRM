package ru.javamentor.EcoCRM.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.EcoCRM.model.ManagementCompany;
import ru.javamentor.EcoCRM.service.ManagementCompanyService;
import ru.javamentor.EcoCRM.service.ProjectService;

@RestController
@RequestMapping("/manage_company")
public class StepsManagementRestController {

    @Autowired
    ManagementCompanyService managementCompanyService;

    @Autowired
    ProjectService projectService;

    @ResponseBody
    @PostMapping("/add")
//    @RequestMapping(method = RequestMethod.POST, value = "/add", consumes ="application/json")
    public Long saveManagInfo(@RequestParam(value = "projectid") Long projectId, @RequestBody ManagementCompany managementCompany) {
        if(managementCompanyService.get(projectId) == null) {
            managementCompanyService.insert(managementCompany);
        } else {
            managementCompanyService.update(managementCompany);
        }
        return projectId;
    }
}
