package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.StepDao;
import ru.javamentor.EcoCRM.dto.stepDTO.*;
import ru.javamentor.EcoCRM.model.*;
import ru.javamentor.EcoCRM.model.embedded.Status;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;

import java.util.List;

@Service
public class StepServiceImpl extends AbstractServiceImpl<Step> implements StepService {

    private StepDao stepDao;

    @Autowired
    public StepServiceImpl(StepDao stepDao) {
        this.stepDao = stepDao;
    }

    @Autowired
    public TaskService taskService;

    @Autowired
    public ContractorService contractorService;

    @Autowired
    public ProjectService projectService;

    @Override
    public Step getProgressStepByProjectId(Long projectId){
       return stepDao.getProgressStepByProjectId(projectId);
    }

    //todo Удалить метод когда по умолчанию при создании проекта Step #1 будет in_progress
    public void putProgressStatusToFirstStep(){
        List<Step> steps = stepDao.getAll();
        for(Step step: steps){
            if(step.getStepNumber() == StepNumber.STEP_1){
                step.setStatus(Status.IN_PROGRESS);
                stepDao.update(step);
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Step> getAllByprojectId(Long id){
        return stepDao.getAllByProjectId(id);
    }

    @Override
    public StepDao getDao() {
        return stepDao;
    }

    @Override
    public Step getStepByProjectIdAndStepNumber(Long projectId, StepNumber stepNumber) {
        return stepDao.getStepByProjectIdAndStepNumber(projectId, stepNumber);
    }

    @Override
    public StepDTO getStepDTO(Long id, StepNumber stepNumber) {
        switch (stepNumber) {
            case STEP_1: return getStep1(id, stepNumber);
            case STEP_2: return getStep2(id, stepNumber);
            case STEP_3: return getStep3(id, stepNumber);
            case STEP_4: return getStep4(id, stepNumber);
            case STEP_5: return getStep5(id, stepNumber);
            case STEP_6: return getStep6(id, stepNumber);
            case STEP_7: return getStep7(id, stepNumber);
            case STEP_8: return getStep8(id, stepNumber);
        }
        return null;
    }

    private StepDTO getStep1(Long id, StepNumber stepNumber) {
        Long stepId = getStepByProjectIdAndStepNumber(id, stepNumber).getId();
        List<Task> tasks = taskService.getAllByStepId(stepId);
        return new Step1DTO(stepId, tasks);
    }

    private StepDTO getStep2(Long id, StepNumber stepNumber) {
        Long stepId = getStepByProjectIdAndStepNumber(id, stepNumber).getId();
        List<Task> tasks = taskService.getAllByStepId(stepId);
        ManagementCompany company = projectService.get(id).getManagementCompany();
        return new Step2DTO(company, stepId, tasks);
    }

    private StepDTO getStep3(Long id, StepNumber stepNumber) {
        List<Contractor> contractors = contractorService.getAll();
        Long stepId = getStepByProjectIdAndStepNumber(id, stepNumber).getId();
        List<Task> tasks = taskService.getAllByStepId(stepId);
        return new Step3DTO(contractors, stepId, tasks);
    }

    private StepDTO getStep4(Long id, StepNumber stepNumber) {
        Long stepId = getStepByProjectIdAndStepNumber(id, stepNumber).getId();
        List<Task> tasks = taskService.getAllByStepId(stepId);
        return new Step4DTO(stepId, tasks);
    }

    private StepDTO getStep5(Long id, StepNumber stepNumber) {
        Long stepId = getStepByProjectIdAndStepNumber(id, stepNumber).getId();
        List<Task> tasks = taskService.getAllByStepId(stepId);
        return new Step5DTO(stepId, tasks);
    }

    private StepDTO getStep6(Long id, StepNumber stepNumber) {
        Long stepId = getStepByProjectIdAndStepNumber(id, stepNumber).getId();
        List<Task> tasks = taskService.getAllByStepId(stepId);
        return new Step6DTO(stepId, tasks);
    }

    private StepDTO getStep7(Long id, StepNumber stepNumber) {
        Long stepId = getStepByProjectIdAndStepNumber(id, stepNumber).getId();
        List<Task> tasks = taskService.getAllByStepId(stepId);
        Report report = projectService.getReportByWithIdProject(id);
        return new Step7DTO(report, stepId, tasks);
    }

    private StepDTO getStep8(Long id, StepNumber stepNumber) {
        Long stepId = getStepByProjectIdAndStepNumber(id, stepNumber).getId();
        List<Task> tasks = taskService.getAllByStepId(stepId);
        return new Step8DTO(stepId, tasks);
    }

}
