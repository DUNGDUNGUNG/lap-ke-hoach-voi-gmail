package com.example.schedulingtaskinspringboot.service.impl;

import com.example.schedulingtaskinspringboot.model.HistorySendEmail;
import com.example.schedulingtaskinspringboot.repository.HistorySendEmailRepository;
import com.example.schedulingtaskinspringboot.service.HistorySendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HistorySendEmailServiceImpl implements HistorySendEmailService<HistorySendEmail> {

    @Autowired
    HistorySendEmailRepository historySendEmailRepository;

    @Override
    public Page<HistorySendEmail> findAll(Pageable pageable) {
        return historySendEmailRepository.findAll(pageable);
    }

    @Override
    public void save(HistorySendEmail historySendEmail) {
        historySendEmailRepository.save(historySendEmail);
    }
}
