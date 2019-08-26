package ru.javamentor.EcoCRM.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.Report;
import ru.javamentor.EcoCRM.service.ProjectService;
import ru.javamentor.EcoCRM.service.ReportService;

@RestController
@RequestMapping("/report")
public class ReportRestController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private ProjectService projectService;

    @GetMapping("/all/{projectId}")
    public Report allReport(@PathVariable("projectId") Long id){
        Report report = projectService.getReportByWithIdProject(id);
        return report;
    }

    @PostMapping("/add/{projectId}")
    public void addReport(@RequestBody Report report, @PathVariable("projectId") Long id){
        Project project =  projectService.get(id);
        if( report.getId() == null){
            project.setReport(report);
            projectService.update(project);
        } else {
            reportService.update(report);
        }
    }
}

