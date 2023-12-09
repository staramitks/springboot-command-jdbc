package home.amit.springboot.app.test;

import home.amit.springboot.app.test.context.datasource.DataSourceContextProvider;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {TestContextProvider.class, DataSourceContextProvider.class})
public class SpringBootApplicationTest {


	@Value("${heart.beat.sql}")
	private String heartBeatSQL;

	@Test
	void contextLoads() {

	}

}
