package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.model.Token;

@Service
public class SchedulerServiceImpl implements  SchedulerService{

    @Autowired
    TokenService tokenService;

    @Override
    @Scheduled(initialDelayString = "0", fixedDelayString = "20000")
    public void tokenLifeCycle() {


        System.out.println("SHEDULED TASK WORKING!!!");

    }
}
