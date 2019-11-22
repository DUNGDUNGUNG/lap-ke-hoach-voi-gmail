package com.example.schedulingtaskinspringboot.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "history_send_email")
@Data
public class HistorySendEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime time;
    private String status;
    private String title;
    private String content;

    @OneToOne
    @JoinColumn(name = "send_email_id")
    private SendEmail sendEmail;

    @OneToOne
    @JoinColumn(name = "receive_email_id")
    private ReceiveEmail receiveEmail;

}
