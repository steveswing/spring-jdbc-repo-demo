package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSender;

import com.example.demo.util.EmailService;

import static org.mockito.Mockito.mock;

@Configuration
public class TestEmailConfig {
    @Bean
    @Primary
    public JavaMailSender javaMailSender() {
        return mock(JavaMailSender.class);
    }

    @Bean
    @Primary
    public EmailService emailService() {
        return mock(EmailService.class);
    }
}
