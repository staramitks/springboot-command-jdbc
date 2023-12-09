package home.amit.springboot.app.service;
/*
User :- AmitSingh
Date :- 12/9/2023
Time :- 1:45 PM
Year :- 2023
*/

import home.amit.springboot.app.dao.HeartBeatDAO;
import org.springframework.stereotype.Service;

@Service
public class HeartBeatServiceImpl implements HeartBeatService{

    private final HeartBeatDAO heartBeatDAO;
    public HeartBeatServiceImpl(HeartBeatDAO heartBeatDAO)
    {
        this.heartBeatDAO=heartBeatDAO;
    }

    @Override
    public int isHeartBeating() {
        return heartBeatDAO.isHeartBeating();
    }
}
