package home.amit.springboot.app.test;
/*
User :- AmitSingh
Date :- 12/9/2023
Time :- 2:31 PM
Year :- 2023
*/

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;

@TestConfiguration
public class TestContextProvider {


    @Value("${heart.beat.sql}")
    private String heartBeatSQL;


    @Bean
    @Primary
    protected JdbcTemplate getJDBCTemplate(){
       JdbcTemplate appJdbcTemplate= Mockito.mock(JdbcTemplate.class);
        Mockito.when(appJdbcTemplate.queryForObject(this.heartBeatSQL, Integer.class, new Object[]{}))
                .thenReturn(20);
        return appJdbcTemplate;
    }



}
