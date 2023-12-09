package home.amit.springboot.app.datasource;
/*
User :- AmitSingh
Date :- 12/9/2023
Time :- 11:49 AM
Year :- 2023
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;

@Configuration
public class AppDataSource {

    @Value(("${spring.datasource.url}"))
    private String url;

    @Value(("${spring.datasource.username}"))
    private String username;

    @Value(("${spring.datasource.password}"))
    private String password;

    @Value(("${spring.datasource.driver-class-name}"))
    private String driverClassName;

    @Bean("dataSource")
    @Primary
    public DataSource dataSource()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(this.url);
        dataSourceBuilder.username(this.username);
        dataSourceBuilder.password(this.password);
        dataSourceBuilder.driverClassName(this.driverClassName);
        return dataSourceBuilder.build();
    }

    @Bean(name = "appJdbcTemplate")
    @Autowired
    public JdbcTemplate createJdbcTemplate(@Qualifier("dataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}