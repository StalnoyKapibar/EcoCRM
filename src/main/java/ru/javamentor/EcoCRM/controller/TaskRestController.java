package ru.javamentor.EcoCRM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.EcoCRM.model.Step;
import ru.javamentor.EcoCRM.model.Task;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;
import ru.javamentor.EcoCRM.model.embedded.TaskType;
import ru.javamentor.EcoCRM.service.ProjectService;
import ru.javamentor.EcoCRM.service.StepService;
import ru.javamentor.EcoCRM.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskRestController {

    @Autowired
    public TaskService taskService;

    @Autowired
    public ProjectService projectService;

    @Autowired
    public StepService stepService;

    @RequestMapping(value = "/get_1_step/{stepid}", method = RequestMethod.GET)
    public List<Task> adminPageEmployerToEdit(@PathVariable Long stepid) {
        List <Task> tasks = taskService.getAllByStepId(stepid);
        return tasks;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Task addTask(@RequestParam(value = "project_id") Long projectId,
                        @RequestParam(value = "step_number")Integer number,
                        @RequestParam(value = "taskName")String taskName,
                        @RequestParam(value = "description")String description){
        StepNumber stepNumber = StepNumber.STEP_1;
        switch (number) {
            case  (1):
                stepNumber = StepNumber.STEP_1;
            case (2):
                stepNumber = StepNumber.STEP_2;
            case (3):
                stepNumber = StepNumber.STEP_3;
            case (4):
                stepNumber = StepNumber.STEP_4;
            case (5):
                stepNumber = StepNumber.STEP_5;
            case (6):
                stepNumber = StepNumber.STEP_6;
            case (7):
                stepNumber = StepNumber.STEP_7;
            case (8):
                stepNumber = StepNumber.STEP_8;
        }
        Step step = stepService.getStepByProjectIdAndStepNumber(projectId, stepNumber);
        Task task = new Task(taskName, description,step, TaskType.CUSTOM);
        taskService.insert(task);
        return taskService.get(task.getId());
    }
}
