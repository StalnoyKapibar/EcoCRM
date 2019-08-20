package ru.javamentor.EcoCRM.init;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.javamentor.EcoCRM.model.*;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;
import ru.javamentor.EcoCRM.service.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

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
    private PetitionService petitionService;

    @Autowired
    private StepService stepService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private Faker faker = new Faker(new Locale("ru"));

    private Random random = new Random();

    public void init() {
        initRoles();
        initUsers();
        initContractors();
        initManagement();
        initPetition();
        initProject();
    }

    private void initRoles() {
        Authority adminAuthority = new Authority("ROLE_ADMIN");
        authoritiesService.insert(adminAuthority);
        Authority userAuthority = new Authority("ROLE_USER");
        authoritiesService.insert(userAuthority);
    }

    private void initUsers() {
        for (int i = 1; i < 50; i++) {
            User user = new User();
            user.setName(faker.name().firstName());
            user.setSurname(faker.name().lastName());
            user.setEmail(faker.internet().emailAddress());
            user.setLink(faker.internet().emailAddress());
            user.setProfession(faker.job().position());
            user.setPassword(bCryptPasswordEncoder.encode("1"));
            user.setEnabled(true);
            user.setNotToDo(faker.chuckNorris().fact());
            List<Authority> roles = new ArrayList<>();
            roles.add(authoritiesService.get(2));
            user.setAuthorities(roles);
            userService.insert(user);
        }
    }

    private void initContractors() {
        for (int i = 1; i < 15; i++) {
            Contractor contractor = new Contractor();
            contractor.setName(faker.company().name());
            contractor.setRowType(faker.commerce().material());
            contractor.setLink(faker.company().url());
            contractor.setContactPerson(faker.name().nameWithMiddle());
            contractor.setPhoneNumber(faker.phoneNumber().phoneNumber());
            contractor.setLinkByPerson(faker.company().url());
            contractor.setCollectorType(faker.commerce().material());
            contractor.setDescription(faker.company().catchPhrase());
            contractorService.insert(contractor);
        }
    }

    private void initManagement() {
        for (int i = 1; i < 15; i++) {
            ManagementCompany company = new ManagementCompany();
            company.setName(faker.company().name());
            company.setInn(faker.commerce().promotionCode());
            company.setManagerName(faker.name().firstName());
            company.setManagerSurname(faker.name().lastName());
            company.setPhoneNumber(faker.phoneNumber().phoneNumber());
            company.setEmail(faker.internet().emailAddress());
            company.setClock("13:00-19:00");
            company.setDescription(faker.harryPotter().quote());
            company.setNextContactDate(LocalDateTime.of(2019, 6, 25, 11, 0));
            managementCompanyService.insert(company);
        }
    }

    private void initPetition() {
        for (int i = 1; i < 50; i++) {
            Petition petition = new Petition();
            petition.setEmail(faker.internet().emailAddress());
            petition.setUserName(faker.name().fullName());
            petition.setContactInformation(faker.phoneNumber().phoneNumber());
            petition.setStatusHome("статус_дома");
            petition.setSeparateCollection(faker.commerce().material());
            petition.setTypeOfRawMaterial(faker.commerce().material());
            petitionService.insert(petition);
        }
    }

    private void initProject() {
        for (int i = 1; i < 30; i++) {
            Project project = new Project();
            project.setTitle(faker.company().name());
            User user = userService.get((long)random.nextInt(50));
            project.setManager(user);
            project.setPetition(petitionService.get(i));
            projectService.insert(project);
            initSteps(project);
        }
    }

    public void initSteps(Project project) {
        for (StepNumber stepNumber : StepNumber.values()) {
            Step step = new Step();
            step.setProject(project);
            step.setStepNumber(stepNumber);
            stepService.insert(step);
            switch (stepNumber) {
                case STEP_1:addTaskForStep1(step);
                    break;
                case STEP_2:addTaskForStep2(step);
                    break;
                case STEP_3:addTaskForStep3(step);
                    break;
                case STEP_4:addTaskForStep4(step);
                    break;
                case STEP_5:addTaskForStep5(step);
                    break;
                case STEP_6:addTaskForStep6(step);
                    break;
                case STEP_7:addTaskForStep7(step);
                    break;
                case STEP_8:addTaskForStep8(step);
                    break;
            }
        }
    }

    private void addTaskForStep1(Step step) {
        taskService.insert(new TaskByStep("Заполнить форму заявителя", step));
        taskService.insert(new TaskByStep("Добавить данные о соседях", step));
        taskService.insert(new TaskByStep("Добавить фото контейнера", step));
    }

    private void addTaskForStep2(Step step) {
        taskService.insert(new TaskByStep("Заполнить форму управляющей компании", step));
    }

    private void addTaskForStep3(Step step) {
        taskService.insert(new TaskByStep("Выбрать компанию заготовителя", step));
        taskService.insert(new TaskByStep("Назначить встречу заготовителя и управляющей компании", step));
    }

    private void addTaskForStep4(Step step) {
        taskService.insert(new TaskByStep("Заключить договор", step));
    }

    private void addTaskForStep5(Step step) {
        taskService.insert(new TaskByStep("Установка контейнера", step));
    }

    private void addTaskForStep6(Step step) {
        taskService.insert(new TaskByStep("Разработать макет листовок", step));
        taskService.insert(new TaskByStep("Печать листовок", step));
        taskService.insert(new TaskByStep("Публикация листовок на досках информирования", step));
        taskService.insert(new TaskByStep("Мероприятие  участием жителей", step));
    }

    private void addTaskForStep7(Step step) {
        taskService.insert(new TaskByStep("Заполнить отчет", step));
    }

    private void addTaskForStep8(Step step) {
        taskService.insert(new TaskByStep("Проверка результата через месяц", step));
    }
}
