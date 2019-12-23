package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ActiveProfiles("test")
@Primary
@EnableJdbcRepositories(basePackages = {"com.example.demo"})
@ComponentScan(basePackages = {"com.example.demo"}, basePackageClasses = {TestEmailConfig.class, H2TestProfileJPAConfig.class})
public class H2TestProfileJPAConfig extends AbstractJdbcConfiguration {
    @Bean
    @Profile("test")
    public DataSource dataSource() {
        return DataSourceBuilder.create().driverClassName("org.h2.Driver").url("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1").username("sa").password("").build();
    }
}
