package home.amit.springboot.app.runner;
/*
User :- AmitSingh
Date :- 12/9/2023
Time :- 1:44 PM
Year :- 2023
*/

import home.amit.springboot.app.service.ApplicationService;
import home.amit.springboot.app.service.MyMessagePrinting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Runner implements CommandLineRunner {

    @Autowired
    private ApplicationService applicationService;

    @Override
    public void run(String... args) throws Exception {
        //runInLoop();
        log.info("Number returned is "+ applicationService.isHeartBeating());
        System.out.println("Logger Name is "+log.getName());
        MyMessagePrinting myMessagePrinting= new MyMessagePrinting();
        myMessagePrinting.testMessage();
    }

    private void runInLoop()
    {
        int counter=0;
        do{

            printMessages();
            try{
                System.out.println("Iterarting "+counter +"th time");
                counter++;
                Thread.sleep(10000);
            }
            catch(Exception e)
            {
                System.out.printf("Error due to thread ,"+e);
            }

        }while(true);
    }
    private void printMessages(){

        System.out.println("##############################################################");
        System.out.println("Check application Output ==>" + applicationService.isHeartBeating());
        System.out.println("##############################################################");
    }
}
