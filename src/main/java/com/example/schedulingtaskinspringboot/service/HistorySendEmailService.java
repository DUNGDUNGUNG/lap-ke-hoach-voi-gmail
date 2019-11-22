package com.example.schedulingtaskinspringboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HistorySendEmailService<E> {
    Page<E> findAll(Pageable pageable);
    void save (E historySendEmail);
}
