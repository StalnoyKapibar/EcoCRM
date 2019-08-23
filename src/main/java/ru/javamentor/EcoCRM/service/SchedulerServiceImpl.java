package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerServiceImpl implements  SchedulerService{

    @Autowired
    TokenService tokenService;

    private static long beginTime = System.currentTimeMillis();
    long ServerUptime = 0;

    @Override
    @Scheduled(initialDelayString = "0", fixedDelayString = "${tokenCleanInterval}")
    public void tokenLifeCycle() {
        System.out.println("Token cleaning run...");
        ServerUptime = System.currentTimeMillis() - beginTime;
        System.out.println("Server UpTime is : " + ServerUptime/1000 + " seconds ");
        tokenService.deleteOldTokens();
    }
}
