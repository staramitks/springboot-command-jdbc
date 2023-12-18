package home.amit.springboot.app.test;
/*
User :- AmitSingh
Date :- 12/9/2023
Time :- 2:31 PM
Year :- 2023
*/

import home.amit.springboot.app.dao.ApplicationDAO;
import home.amit.springboot.app.dao.ApplicationDAOImpl;
import home.amit.springboot.app.service.ApplicationService;
import home.amit.springboot.app.service.ApplicationServiceImpl;
import home.amit.springboot.app.service.Calculator;
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
    protected ApplicationDAO getApplicationDAO(){
        ApplicationDAO applicationDAO= Mockito.mock(ApplicationDAOImpl.class);
        Mockito.when(applicationDAO.isHeartBeating())
                .thenReturn(29);
        Mockito.when(applicationDAO.getMessagesCount())
                .thenReturn(99);
        return applicationDAO;
    }

    @Bean
    @Primary
    public Calculator getCalculator(){

        Calculator calculator=Mockito.mock(Calculator.class);
        Mockito.when(calculator.divide(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(550.0);
        return calculator;
    }


//    @Bean
//    @Primary
//    protected ApplicationService getApplicationService(){
//        ApplicationService applicationService= Mockito.mock(ApplicationServiceImpl.class);
//        Mockito.when(applicationService.isHeartBeating())
//                .thenReturn(29);
//        Mockito.when(applicationService.getMessagesCount())
//                .thenReturn(99);
//        return applicationService;
//    }


}
