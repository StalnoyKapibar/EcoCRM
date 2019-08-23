package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.dao.AbstractDao;
import ru.javamentor.EcoCRM.dao.StepDao;
import ru.javamentor.EcoCRM.model.Step;
import ru.javamentor.EcoCRM.model.embedded.Status;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;

import java.util.List;

@Service
public class StepServiceImpl extends AbstractServiceImpl<Step> implements StepService {
    @Autowired
    public StepServiceImpl(StepDao stepDao) {
        this.stepDao = stepDao;
    }

    @Autowired
    private StepDao stepDao;

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

    public List<Step> getAllByprojectId(Long id){
        return stepDao.getAllByProjectId(id);
    }

    public StepDao getDao() {
        return stepDao;
    }

    @Override
    public Step getStepByProjectIdAndStepNumber(Long projectId, StepNumber stepNumber) {
        return stepDao.getStepByProjectIdAndStepNumber(projectId, stepNumber);
    }
}
