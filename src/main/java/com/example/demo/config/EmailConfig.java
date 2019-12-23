package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.util.EmailService;

@Configuration
public class EmailConfig {
    @Bean
    EmailService emailService() {
        return new EmailService();
    }
}
