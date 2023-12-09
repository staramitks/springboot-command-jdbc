package home.amit.springboot.app.runner;
/*
User :- AmitSingh
Date :- 12/9/2023
Time :- 1:44 PM
Year :- 2023
*/

import home.amit.springboot.app.service.HeartBeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private HeartBeatService heartBeatService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("##############################################################");
        System.out.println("Check application Output ==>" +heartBeatService.isHeartBeating());
        System.out.println("##############################################################");

    }
}
