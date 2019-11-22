package com.example.schedulingtaskinspringboot.config;

import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.config.TransportStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigEmail {

    @Bean
    public Mailer mailer() {
        return MailerBuilder
                .withSMTPServer("smtp.gmail.com", 587, "santafe9xyb@gmail.com", "frwsnarhvaoadqpf")
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .buildMailer();
    }
}
