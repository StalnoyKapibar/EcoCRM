package ru.javamentor.EcoCRM.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.EcoCRM.model.Step;
import ru.javamentor.EcoCRM.model.Task;
import ru.javamentor.EcoCRM.model.embedded.Status;
import ru.javamentor.EcoCRM.model.embedded.StepNumber;
import ru.javamentor.EcoCRM.model.embedded.TaskStatus;
import ru.javamentor.EcoCRM.model.embedded.TaskType;
import ru.javamentor.EcoCRM.service.ProjectService;
import ru.javamentor.EcoCRM.service.StepService;
import ru.javamentor.EcoCRM.service.TaskService;

import java.nio.file.LinkOption;
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

    @RequestMapping(value = "/get_by_step/{stepid}", method = RequestMethod.GET)
    public List<Task> adminPageEmployerToEdit(@PathVariable Long stepid) {
        return taskService.getAllByStepId(stepid);
    }

    @RequestMapping(value = "/distinct", method = RequestMethod.POST)
    public Task getCustomTask(@RequestParam(value = "projectId")long projectId,
                              @RequestParam(value = "stepNumber") StepNumber stepNumber,
                              @RequestParam(value = "taskType") TaskType taskType) {
        return taskService.getDistinctStaticTask(projectId, stepNumber, taskType);
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public Task getTaskById(@RequestParam(value = "id")long id) {
        return taskService.get(id);
    }

    @RequestMapping(value = "/update")
    public void persistTask(@RequestParam(value = "task")Task task) {
        taskService.update(task);
    }

    @RequestMapping(value = "/change_status", method = RequestMethod.POST)
    public void changeTaskStatus(@RequestParam(value = "id")long id) {
        Task task = taskService.get(id);
        if(task.getTaskStatus().equals(Status.TODO)) {
            task.setTaskStatus(Status.DONE);
        } else {
            task.setTaskStatus(Status.TODO);
        }
        taskService.update(task);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Task addTask(@RequestParam(value = "project_id") Long projectId,
                        @RequestParam(value = "step_number") Integer number,
                        @RequestParam(value = "taskName") String taskName,
                        @RequestParam(value = "description") String description) {
        StepNumber stepNumber = StepNumber.STEP_1;
        switch (number) {
            case (1):
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
        Task task = new Task(taskName, description, step, TaskType.CUSTOM);
        taskService.insert(task);
        return taskService.get(task.getId());
    }
}
