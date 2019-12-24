package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
public class H2TestProfileJPAConfig {
    @Bean
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create().driverClassName("org.h2.Driver").url("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1").username("sa").password("").build();
    }
}
