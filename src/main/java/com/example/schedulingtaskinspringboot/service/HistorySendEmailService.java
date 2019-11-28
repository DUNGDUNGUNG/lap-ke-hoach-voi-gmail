package com.example.schedulingtaskinspringboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HistorySendEmailService<E> {
    Page<E> findAll(Pageable pageable);
    List<E> findAllHistory();
    void save (E historySendEmail);
}
