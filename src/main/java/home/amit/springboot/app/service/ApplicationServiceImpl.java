package home.amit.springboot.app.service;
/*
User :- AmitSingh
Date :- 12/9/2023
Time :- 1:45 PM
Year :- 2023
*/

import home.amit.springboot.app.dao.HeartBeatDAO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HeartBeatServiceImpl implements HeartBeatService{


    //private static final Logger log = LoggerFactory.getLogger("serviceLogger");
    private final HeartBeatDAO heartBeatDAO;
    public HeartBeatServiceImpl(HeartBeatDAO heartBeatDAO)
    {
        this.heartBeatDAO=heartBeatDAO;
    }


    @Override
    public int isHeartBeating() {
        String loggerName = log.getName();
        System.out.println("Logger name in YourClass: " + loggerName);
        if(log.isDebugEnabled()) {
            log.debug("Logging from " + this.getClass().getCanonicalName());
        }
        return heartBeatDAO.isHeartBeating();
    }

    @Override
    public int getMessagesCount() {
        return 100;
    }
}
