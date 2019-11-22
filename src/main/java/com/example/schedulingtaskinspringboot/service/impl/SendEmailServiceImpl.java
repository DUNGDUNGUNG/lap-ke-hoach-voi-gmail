package com.example.schedulingtaskinspringboot.service.impl;

import com.example.schedulingtaskinspringboot.model.SendEmail;
import com.example.schedulingtaskinspringboot.repository.SendEmailRepository;
import com.example.schedulingtaskinspringboot.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendEmailServiceImpl implements SendEmailService<SendEmail> {

    @Autowired
    SendEmailRepository sendEmailRepository;

    @Override
    public void save(SendEmail sendEmail) {
        sendEmailRepository.save(sendEmail);
    }

}
