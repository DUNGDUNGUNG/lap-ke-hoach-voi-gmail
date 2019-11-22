package com.example.schedulingtaskinspringboot.repository;

import com.example.schedulingtaskinspringboot.model.HistorySendEmail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorySendEmailRepository extends PagingAndSortingRepository<HistorySendEmail, Long> {
}
