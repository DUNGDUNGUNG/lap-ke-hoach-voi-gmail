package com.example.schedulingtaskinspringboot.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "send_email")
@Data
public class SendEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String title;
    private String content;

}
