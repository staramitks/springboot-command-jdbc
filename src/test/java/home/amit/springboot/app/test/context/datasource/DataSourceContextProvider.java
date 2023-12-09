package home.amit.springboot.app.test.context.datasource;
/*
User :- AmitSingh
Date :- 12/9/2023
Time :- 3:34 PM
Year :- 2023
*/

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import javax.sql.DataSource;

@TestConfiguration
public class DataSourceContextProvider {
        @Bean
        @Primary
        public DataSource dataSource() {
            // Use an embedded H2 database for testing
            return new EmbeddedDatabaseBuilder()
                    .setType(EmbeddedDatabaseType.H2)
                    .build();
        }
}
