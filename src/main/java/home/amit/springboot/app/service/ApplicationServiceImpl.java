package home.amit.springboot.app.service;
/*
User :- AmitSingh
Date :- 12/9/2023
Time :- 1:45 PM
Year :- 2023
*/

import home.amit.springboot.app.dao.ApplicationDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ApplicationServiceImpl implements ApplicationService {


    //private static final Logger log = LoggerFactory.getLogger("serviceLogger");
    private final ApplicationDAO applicationDAO;
    public ApplicationServiceImpl(ApplicationDAO applicationDAO)
    {
        this.applicationDAO = applicationDAO;
    }


    @Override
    public int isHeartBeating() {
        String loggerName = log.getName();
        int result=applicationDAO.isHeartBeating();

        System.out.println("Logger name in YourClass: " + loggerName);
        if(log.isDebugEnabled()) {
            log.debug("Returning Successfully with result of " + result);
        }
        return applicationDAO.isHeartBeating();
    }

    @Override
    public int getMessagesCount() {
        return applicationDAO.getMessagesCount();
    }
}
