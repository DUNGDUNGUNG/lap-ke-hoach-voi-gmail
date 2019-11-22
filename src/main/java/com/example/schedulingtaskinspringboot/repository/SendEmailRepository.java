package com.example.schedulingtaskinspringboot.repository;

import com.example.schedulingtaskinspringboot.model.SendEmail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SendEmailRepository extends PagingAndSortingRepository<SendEmail, Long> {
}
