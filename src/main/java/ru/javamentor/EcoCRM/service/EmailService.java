package ru.javamentor.EcoCRM.service;

import org.springframework.mail.javamail.JavaMailSender;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);

    JavaMailSender getEmailSender();
}
