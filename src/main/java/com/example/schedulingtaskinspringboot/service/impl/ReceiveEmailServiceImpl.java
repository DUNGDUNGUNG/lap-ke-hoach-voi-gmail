package com.example.schedulingtaskinspringboot.service.impl;

import com.example.schedulingtaskinspringboot.model.ReceiveEmail;
import com.example.schedulingtaskinspringboot.repository.ReceiveEmailRepository;
import com.example.schedulingtaskinspringboot.service.ReceiveEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiveEmailServiceImpl implements ReceiveEmailService<ReceiveEmail> {

    @Autowired
    ReceiveEmailRepository receiveEmailRepository;

    @Override
    public void save(ReceiveEmail receive) {
        receiveEmailRepository.save(receive);
    }
}
