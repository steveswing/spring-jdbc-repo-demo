package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.util.EmailService;

import static org.mockito.Mockito.mock;

@Configuration
@ActiveProfiles("test")
@Primary
@ComponentScan(basePackages = {"com.example.demo"})
public class TestEmailConfig {
    @Bean
    @Profile("test")
    public JavaMailSender javaMailSender() {
        return mock(JavaMailSender.class);
    }

    @Bean
    @Profile("test")
    public EmailService emailService() {
        return mock(EmailService.class);
    }
}
