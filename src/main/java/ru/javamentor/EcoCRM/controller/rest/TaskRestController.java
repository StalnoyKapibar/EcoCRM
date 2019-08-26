package ru.javamentor.EcoCRM.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.EcoCRM.dto.TaskDTO;
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
    public Task addTask(@RequestParam(value = "step_id") Long id, @RequestBody TaskDTO taskDTO){
        Step step = stepService.get(id);
        Task task = new Task(taskDTO.getName(), taskDTO.getDescription(), step, TaskType.CUSTOM);
        taskService.insert(task);
        return taskService.get(task.getId());
    }
}
