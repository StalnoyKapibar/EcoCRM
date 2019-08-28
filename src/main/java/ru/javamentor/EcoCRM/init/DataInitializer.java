package ru.javamentor.EcoCRM.init;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.javamentor.EcoCRM.model.*;
import ru.javamentor.EcoCRM.model.embedded.Status;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;
import ru.javamentor.EcoCRM.model.embedded.TaskType;
import ru.javamentor.EcoCRM.model.petition.embedded.TrashType;
import ru.javamentor.EcoCRM.service.*;

import java.time.LocalDate;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.*;

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
    @Qualifier("imageService")
    ImageService imageService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private Faker faker = new Faker(new Locale("ru"));

    private Random random = new Random();

    public void init() throws IOException {
        initRoles();
        initBaseUserAndAdmin();
        initUsers();
        initContractors();
        initManagement();
        initPetition();
        initProject();
        initPhoto();
    }

    //вспомагательный метод для изменения автарки пользователю 1
    private void initPhoto() throws IOException {
        User user = userService.get(1);
        //user.setPhoto(imageService.resizeImage(ImageIO.read(new File("/home/whitenoise/Документы/CRMBootCamp/EcoCRM/src/main/resources/static/private/images/avatar.png")),150,150));
        //user.setPhoto(imageService.resizeImage(ImageIO.read(new File("src\\main\\resources\\static\\private\\images\\photo.png")),150,150));
        user.setPhoto(imageService.resizeImage(ImageIO.read(new File("/Users/aitalina/Desktop/CRM/src/main/resources/static/private/images/avatar.png")),150,150));
        userService.update(user);
    }



    private void initRoles() {
        Authority adminAuthority = new Authority("ROLE_ADMIN");
        authoritiesService.insert(adminAuthority);
        Authority userAuthority = new Authority("ROLE_USER");
        authoritiesService.insert(userAuthority);
    }
    private void initBaseUserAndAdmin() throws IOException {
        User admin = new User();
        admin.setName("Simon");
        admin.setSurname("Travalgia");
        //admin.setPhoto(imageService.resizeImage(ImageIO.read(new File("src\\main\\resources\\static\\private\\images\\avatar.png")),150,150));
        //admin.setPhoto(imageService.resizeImage(ImageIO.read(new File("/home/whitenoise/Документы/CRMBootCamp/EcoCRM/src/main/resources/static/private/images/avatar.png")),150,150));
        admin.setPhoto(imageService.resizeImage(ImageIO.read(new File("/Users/aitalina/Desktop/CRM/src/main/resources/static/private/images/avatar.png")),150,150));
        admin.setEmail("admin");
        admin.setPassword(bCryptPasswordEncoder.encode("admin"));
        admin.setProfession("Bastard Operator");
        admin.setNotToDo("User support");
        admin.setLink("https://vk.com/bofh");
        admin.setPatronymic("No");
        admin.setPhone("+7-777-777-77-77");
        admin.setAuthorities(authoritiesService.getAll());

        User user = new User();
        user.setName("Eric");
        user.setSurname("Cartman");
        user.setProfession("Hippy Destroyer");
        user.setPhone("+9-999-999-99-99");
        user.setPatronymic("No");
        user.setLink("https://vk.com/cartman");
        user.setNotToDo("school learning");
        //user.setPhoto(imageService.resizeImage(ImageIO.read(new File("/home/whitenoise/Документы/CRMBootCamp/EcoCRM/src/main/resources/static/private/images/avatar.png")),150,150));
        //user.setPhoto(imageService.resizeImage(ImageIO.read(new File("src\\main\\resources\\static\\private\\images\\avatar.png")),150,150));
        user.setPhoto(imageService.resizeImage(ImageIO.read(new File("/Users/aitalina/Desktop/CRM/src/main/resources/static/private/images/avatar.png")),150,150));
        user.setEmail("user");
        user.setPassword(bCryptPasswordEncoder.encode("user"));
        List<Authority> roles = new ArrayList<>();
        roles.add(authoritiesService.get(2));
        user.setAuthorities(roles);
        userService.insert(user);
        userService.insert(admin);
    }

    private void initUsers() throws IOException {
        for (int i = 1; i < 10; i++) {
            User user = new User();
            user.setName(faker.name().firstName());
            user.setSurname(faker.name().lastName());
            user.setEmail(2 + i + "@mail.ru");
            user.setPhone(faker.phoneNumber().phoneNumber());
            user.setLink(faker.internet().emailAddress());
            user.setProfession(faker.job().position());
            user.setPassword(bCryptPasswordEncoder.encode(2 + i + ""));
            user.setNotToDo(faker.chuckNorris().fact());
            List<Authority> roles = new ArrayList<>();
            roles.add(authoritiesService.get(2));
            user.setAuthorities(roles);
            //user.setPhoto(imageService.resizeImage(ImageIO.read(new File("src\\main\\resources\\static\\private\\images\\avatar.png")),150,150));
            //user.setPhoto(imageService.resizeImage(ImageIO.read(new File("/home/whitenoise/Документы/CRMBootCamp/EcoCRM/src/main/resources/static/private/images/avatar.png")),150,150));
            user.setPhoto(imageService.resizeImage(ImageIO.read(new File("/Users/aitalina/Desktop/CRM/src/main/resources/static/private/images/avatar.png")),150,150));
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
            company.setNextContactDate(new Date(2019, 6, 25));
            managementCompanyService.insert(company);
        }
    }

    private void initPetition() {
        for (int i = 1; i < 50; i++) {
            Petition petition = new Petition();
            petition.setEmail(faker.internet().emailAddress());
            petition.setUserName(faker.name().fullName());
            petition.setContactInformation(faker.phoneNumber().phoneNumber());
            petition.setAddressHome(faker.address().streetName());
            petition.setData(LocalDate.now());

            if(new Random().nextInt() % 2 == 0){
                petition.setHouseDistrict("Другой район");
            } else {
                petition.setHouseDistrict("Адмиралтейский район");
            }
            petitionService.insert(petition);
        }
    }

    private void initProject() {
        for (int i = 1; i < 30; i++) {
            Project project = new Project();
            User user = userService.get((long)(random.nextInt(10) + 1));
            project.setManager(user);
            project.setStartStep(LocalDate.now());
            project.setPetition(petitionService.get(i));
            project.setManagementCompany(managementCompanyService.get(1));
            projectService.insert(project);
            initSteps(project);
        }
    }

    public void initSteps(Project project) {
        boolean hasStatusInProgress = false;
        for (StepNumber stepNumber : StepNumber.values()) {
            Step step = new Step();
            step.setProject(project);
            step.setStepNumber(stepNumber);
            if(!hasStatusInProgress) {
                int randomInt = random.nextInt(2);
                Status status = Status.values()[randomInt];
                if (status.equals(Status.IN_PROGRESS)) {
                    hasStatusInProgress = true;
                }
                step.setStatus(status);
            }
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
        taskService.insert(new Task("Заполнить форму заявителя","Заполнить форму заявителя", step, TaskType.PETITIONER_INFO));
        taskService.insert(new Task("Добавить данные о соседях","Добавить данные о соседях", step, TaskType.NEIGHBOURHOODS_INFO));
        taskService.insert(new Task("Добавить фото контейнера","Добавить фото контейнера", step, TaskType.OLD_CONTAINER_PHOTO));
    }

    private void addTaskForStep2(Step step) {
        taskService.insert(new Task("Заполнить форму управляющей компании","Заполнить форму управляющей компании", step, TaskType.MANAGING_ORGANIZATION_INFO));
    }

    private void addTaskForStep3(Step step) {
        taskService.insert(new Task("Выбрать компанию заготовителя","Выбрать компанию заготовителя", step, TaskType.CONTRACTOR_INFO)); }

    private void addTaskForStep4(Step step) {
        taskService.insert(new Task("Заключить договор","Заключить договор", step, TaskType.OFFER));
    }

    private void addTaskForStep5(Step step) {
        taskService.insert(new Task("Установка контейнера","Установка контейнера", step, TaskType.NEW_CONTAINER_INFO));
    }

    private void addTaskForStep6(Step step) {
        taskService.insert(new Task("Разработать макет листовок", "Разработать макет листовок", step, TaskType.LEAFLETS_DESIGN));
        taskService.insert(new Task("Печать листовок","Печать листовок", step, TaskType.LEAFLETS_PRINT));
        taskService.insert(new Task("Публикация листовок на досках информирования","Публикация листовок на досках информирования", step, TaskType.LEAFLETS_PUBLICATION));
        taskService.insert(new Task("Мероприятие  участием жителей","Мероприятие  участием жителей", step, TaskType.RESIDENTS_ACTIVITIES));
    }

    private void addTaskForStep7(Step step) {
        taskService.insert(new Task("Заполнить отчет", "Заполнить отчет", step, TaskType.CASE_DESCRIPTION));
    }

    private void addTaskForStep8(Step step) {
        taskService.insert(new Task("Проверка результата через месяц","Проверка результата через месяц", step, TaskType.CUSTOM));
    }
}
