package com.example.schedulingtaskinspringboot.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "receive_email")
@Data
public class ReceiveEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;

    @ManyToOne
    @JoinColumn(name = "send_email_id")
    private SendEmail sendEmail;
}
