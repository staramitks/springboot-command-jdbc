package home.amit.springboot.app.service;
/*
User :- AmitSingh
Date :- 12/16/2023
Time :- 10:59 PM
Year :- 2023
*/

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyMessagePrinting {

    public void testMessage(){
      log.info("INFO - This is the method I want to test");
        log.debug("DEBUG - This is the method I want to test");
       // System.out.println("This is the method I want to test");

    }


}
