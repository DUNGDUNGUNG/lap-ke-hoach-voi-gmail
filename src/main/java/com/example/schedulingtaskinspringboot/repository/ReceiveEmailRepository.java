package com.example.schedulingtaskinspringboot.repository;

import com.example.schedulingtaskinspringboot.model.ReceiveEmail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiveEmailRepository extends PagingAndSortingRepository<ReceiveEmail, Long> {
}
