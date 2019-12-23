package com.example.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.icegreen.greenmail.util.GreenMail;

import static org.mockito.Mockito.mock;

@Configuration
public class TestEmailConfig {
    @Bean
    @Primary
    public JavaMailSender javaMailSenderMock() {
        return mock(JavaMailSender.class);
    }

    @Bean
    @ConditionalOnMissingBean(JavaMailSender.class)
    JavaMailSender javaMailSender() {
        final JavaMailSenderImpl sender = new JavaMailSenderImpl();
        final GreenMail greenMail = mailServicesSimulator();
        final String host = greenMail.getSmtp().getServerSetup().getBindAddress();
        final int port = greenMail.getSmtp().getPort();
        sender.setHost(host);
        sender.setPort(port);
        return sender;
    }

    GreenMail mailServicesSimulator() {
        System.setProperty("greenmail.smtp.hostname", "127.0.0.1");
        System.setProperty("greenmail.smtp.port", "4025");
        final GreenMail mailServices = new GreenMail();
        mailServices.start();
        return mailServices;
    }
}
