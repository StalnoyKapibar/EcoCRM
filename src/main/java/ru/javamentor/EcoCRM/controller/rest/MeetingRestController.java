package ru.javamentor.EcoCRM.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.EcoCRM.model.Meeting;
import ru.javamentor.EcoCRM.service.MeetingService;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/meeting")
public class MeetingRestController {

    @Autowired
    private MeetingService meetingService;

    @PostMapping("/{id}/data/{projectId}")
    public Meeting addData(@PathVariable("id") Long id, @RequestBody String date, @PathVariable("projectId") Long projectId) {
        return meetingService.saveMeeting(id, date, projectId);
    }
}
