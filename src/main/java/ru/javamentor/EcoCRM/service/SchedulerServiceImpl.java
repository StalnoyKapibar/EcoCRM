package ru.javamentor.EcoCRM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.javamentor.EcoCRM.model.Token;

import java.util.List;

@Service
public class SchedulerServiceImpl implements  SchedulerService{

    @Autowired
    TokenService tokenService;

    @Override
    @Scheduled(initialDelayString = "10000", fixedDelayString = "10000")
    public void tokenLifeCycle() {

        System.out.println("SHEDULED TASK WORKING!!!");
        //List<Token> allTokens =  tokenService.getAll();
//        long currentTime = System.currentTimeMillis();
//        for (Token token : allTokens) {
//            if (currentTime - token.getTokenCreateTime()  > 60000) {
//                tokenService.delete(token);
//                System.out.println("Token Deleted");
//            }
//        }

        tokenService.deleteOldTokens();

    }
}
