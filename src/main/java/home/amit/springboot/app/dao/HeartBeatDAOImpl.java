package home.amit.springboot.app.dao;
/*
User :- AmitSingh
Date :- 12/9/2023
Time :- 1:40 PM
Year :- 2023
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HeartBeatDAOImpl implements HeartBeatDAO {

    @Value("${heart.beat.sql}")
    private String heartBeatSQL;

    @Autowired
    private JdbcTemplate appJdbcTemplate;

    @Override
    public int isHeartBeating() {
        Integer result = appJdbcTemplate.queryForObject(this.heartBeatSQL, Integer.class, new Object[]{});
        return result;
    }
}
