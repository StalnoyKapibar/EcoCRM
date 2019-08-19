package ru.javamentor.EcoCRM.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.javamentor.EcoCRM.model.*;
import ru.javamentor.EcoCRM.model.embedded.Status;
import ru.javamentor.EcoCRM.service.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component

public class DataInitializer {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthoritiesService authoritiesService;
    @Autowired
    private PointService pointService;
    @Autowired
    private ManagementCompanyService managementCompanyService;
    @Autowired
    private ContractorService contractorService;
    @Autowired
    private ReportService reportService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void init() {
        Authority rootAuthority = new Authority("ROOT");
        Authority managerAuthority = new Authority("MANAGER");
        List<Authority> authorities = new ArrayList<>();
        authorities.add(rootAuthority);
        authorities.add(managerAuthority);

        User rootUser = new User("root@root.com", bCryptPasswordEncoder.encode("root"),  authorities);
        User managerUser = new User("manager@manager.com", bCryptPasswordEncoder.encode("manager"), authorities);

        Point firstPoint = new Point(Float.valueOf("55.779184"), Float.valueOf("49.129974"));
        Point secondPoint = new Point(Float.valueOf("55.778075"), Float.valueOf("49.134452"));

        ManagementCompany firstCompany = new ManagementCompany("firstCompany",
                "123123",
                "first.com",
                "leha",
                "ivanich",
                "lehovich",
                "89999999999",
                "firstcompany@test.com",
                "11:00-12:00",
                "testDecrp123123",
                LocalDateTime.of(2019, 9, 30, 16, 0));
        ManagementCompany secondCompany = new ManagementCompany("secondCompany",
                "321321",
                "second.com",
                "vanya",
                "gorkov",
                "mihaylovich",
                "81111111111",
                "secondcompany@test.com",
                "13:00-19:00",
                "testDecrp321321",
                LocalDateTime.of(2019, 6, 25, 11, 0));

        Contractor firstContractor = new Contractor("firstContr", "testType1", "test1.com",
                "testPerson1", "888888888888", "testLinkByPerson1.com",
                "testCollectorType1", "testDisposalConditions1");
        Contractor secondContractor = new Contractor("secondContr", "testType2", "test2.com",
                "testPerson2", "82222222222", "testLinkByPerson2.com",
                "testCollectorType2", "testDisposalConditions2");
        Contractor thirdContractor = new Contractor("thirdContr", "testType3", "test3.com",
                "testPerson3", "83333333333", "testLinkByPerson3.com",
                "testCollectorType3", "testDisposalConditions3");

        Report firstReport = new Report("firstTestDesc", "firstTestDescLink");
        Report secondReport = new Report("secondTestDesc", "secondTestDescLink");
        Report thirdReport = new Report("thirdTestDesc", "thirdTestDescLink");

        Project firstProject = new Project("firstProjectTittle", Status.IN_PROGRESS, firstPoint, firstCompany, firstContractor, firstReport);
        Project secondProject = new Project("secondProjectTittle", Status.DONE, secondPoint, secondCompany, secondContractor, thirdReport);

        authoritiesService.insert(rootAuthority);
        authoritiesService.insert(managerAuthority);
        userService.insert(rootUser);
        userService.insert(managerUser);
        pointService.insert(firstPoint);
        pointService.insert(secondPoint);
        managementCompanyService.insert(firstCompany);
        managementCompanyService.insert(secondCompany);
        contractorService.insert(firstContractor);
        contractorService.insert(secondContractor);
        contractorService.insert(thirdContractor);
        reportService.insert(firstReport);
        reportService.insert(secondReport);
        reportService.insert(thirdReport);
        projectService.insert(firstProject);
        projectService.insert(secondProject);
    }
}
