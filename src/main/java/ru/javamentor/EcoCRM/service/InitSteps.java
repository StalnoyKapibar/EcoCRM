package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javamentor.EcoCRM.dao.StepDao;
import ru.javamentor.EcoCRM.dao.TaskByStepDao;
import ru.javamentor.EcoCRM.model.Project;
import ru.javamentor.EcoCRM.model.Step;
import ru.javamentor.EcoCRM.model.TaskByStep;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;

public class InitSteps {

    @Autowired
    StepDao stepDao;

    @Autowired
    TaskByStepDao taskByStepDao;

    public void initSteps(Project project) {
        for (StepNumber stepNumber : StepNumber.values()) {
            Step step = new Step();
            step.setStepNumber(stepNumber);
            switch (stepNumber) {
                case STEP_1:addTaskForStep1(project, step);
                break;
                case STEP_2:addTaskForStep2(project, step);
                break;
                case STEP_3:addTaskForStep3(project, step);
                break;
                case STEP_4:addTaskForStep4(project, step);
                break;
                case STEP_5:addTaskForStep5(project, step);
                break;
                case STEP_6:addTaskForStep6(project, step);
                break;
                case STEP_7:addTaskForStep7(project, step);
                break;
                case STEP_8:addTaskForStep8(project, step);
                break;
            }
        }
    }

    private void addTaskForStep1(Project project, Step step) {
        taskByStepDao.insert(new TaskByStep("Заполнить форму заявителя", project.getManager(), step));
        taskByStepDao.insert(new TaskByStep("Добавить данные о соседях", project.getManager(), step));
        taskByStepDao.insert(new TaskByStep("Добавить фото контейнера", project.getManager(), step));
    }

    private void addTaskForStep2(Project project, Step step) {
        taskByStepDao.insert(new TaskByStep("Заполнить форму управляющей компании", project.getManager(), step));
    }

    private void addTaskForStep3(Project project, Step step) {
        taskByStepDao.insert(new TaskByStep("Выбрать компанию заготовителя", project.getManager(), step));
        taskByStepDao.insert(new TaskByStep("Назначить встречу заготовителя и управляющей компании", project.getManager(), step));
    }

    private void addTaskForStep4(Project project, Step step) {
        taskByStepDao.insert(new TaskByStep("Заключить договор", project.getManager(), step));
    }

    private void addTaskForStep5(Project project, Step step) {
        taskByStepDao.insert(new TaskByStep("Установка контейнера", project.getManager(), step));
    }

    private void addTaskForStep6(Project project, Step step) {
        taskByStepDao.insert(new TaskByStep("Разработать макет листовок", project.getManager(), step));
        taskByStepDao.insert(new TaskByStep("Печать листовок", project.getManager(), step));
        taskByStepDao.insert(new TaskByStep("Публикация листовок на досках информирования", project.getManager(), step));
        taskByStepDao.insert(new TaskByStep("Мероприятие  участием жителей", project.getManager(), step));
    }

    private void addTaskForStep7(Project project, Step step) {
        taskByStepDao.insert(new TaskByStep("Заполнить отчет", project.getManager(), step));
    }

    private void addTaskForStep8(Project project, Step step) {
        taskByStepDao.insert(new TaskByStep("Проверка результата через месяц", project.getManager(), step));
    }
}
