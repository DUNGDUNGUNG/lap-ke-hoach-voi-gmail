package com.example.schedulingtaskinspringboot.task;

import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EmailUtils {

    private String ppFilePatch;
    private Properties properties;
    private Session session;

    @Autowired
    Mailer mailer;

    public EmailUtils(String ppFilePatch) {
        this.ppFilePatch = ppFilePatch;
        init();
    }

    public EmailUtils() {
        this.ppFilePatch = "/home/cong/IdeaProjects/scheduling-task-in-spring-boot/config/email.cfg";
        init();
    }

    private void init() {
        properties = new Properties();
        try {
            FileInputStream input = new FileInputStream(ppFilePatch);
            properties.load(input);
        } catch (IOException e) {
        }
        session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(properties.getProperty("username"), properties.getProperty("password"));
            }
        });
        mailer = MailerBuilder
                .usingSession(session)
                .buildMailer();

    }

    public void sendEmail(final String subject, final String content, final String toAddress) {
        Email email = EmailBuilder.startingBlank()
                .from("santafe9xyb@gmail.com")
                .to(toAddress)
                .withSubject(subject)
                .withPlainText(content)
                .buildEmail();
        mailer.sendMail(email);
    }
}