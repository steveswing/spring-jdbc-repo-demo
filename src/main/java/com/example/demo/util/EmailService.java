package com.example.demo.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(String messageRecipient, Path attachment) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            // Static Values That Won't Change
            helper.setFrom("do_not_reply@aep.com");
            helper.setSubject("Invoice Status Information From AEP");
            helper.setText(readAndReturnStandardTemplateEmailAsString(), true);

            helper.setTo(messageRecipient);
            helper.addAttachment("Invoice Data.csv", attachment.toFile());

            emailSender.send(message);
        } catch (MessagingException mex) {
            log.error("Error creating a message", mex);
        } catch (IOException io) {
            log.error("Error sending a message", io);
        }
    }

    private static String readAndReturnStandardTemplateEmailAsString() throws IOException {

        File file = new ClassPathResource("emailTemplates/InvoicesRequested.html").getFile();

        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(String.valueOf(file)), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}
