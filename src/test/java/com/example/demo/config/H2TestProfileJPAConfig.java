package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class H2TestProfileJPAConfig {
    @Bean
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create().driverClassName("org.h2.Driver").url("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1").username("sa").password("").build();
    }
}
