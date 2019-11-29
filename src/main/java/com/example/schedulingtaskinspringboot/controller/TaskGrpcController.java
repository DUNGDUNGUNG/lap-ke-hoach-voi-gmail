package com.example.schedulingtaskinspringboot.controller;

import com.example.grpc.*;

import com.example.schedulingtaskinspringboot.model.HistorySendEmail;
import com.example.schedulingtaskinspringboot.service.impl.HistorySendEmailServiceImpl;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@GRpcService
public class TaskGrpcController extends EmailServiceGrpc.EmailServiceImplBase {

    @Autowired
    HistorySendEmailServiceImpl sendEmailService;

    @Override
    public void readAllHistorySendEmail(ListHistorySendEmailReq request, StreamObserver<ListHistorySendEmailRes> responseObserver) {
        List<HistorySendEmail> historySendEmails = sendEmailService.findAllHistory();
        List<HistorySendEmailM> listItem = new ArrayList<>();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        for (HistorySendEmail historySendEmail : historySendEmails) {
            HistorySendEmailM item = HistorySendEmailM.newBuilder().setId(historySendEmail.getId())
                    .setSendEmailM(SendEmailM.newBuilder().setUsername(historySendEmail.getSendEmail().getUsername()).build())
                    .setTitle(historySendEmail.getTitle())
                    .setStatus(historySendEmail.getStatus())
                    .setReceiveEmail(ReceiveEmailM.newBuilder().setEmail(historySendEmail.getReceiveEmail().getEmail()).build())
                    .setTime(historySendEmail.getTime().format(dateTimeFormatter))
                    .build();
            listItem.add(item);
        }

        ListHistorySendEmailRes listHistorySendEmailRes = ListHistorySendEmailRes.newBuilder().addAllHistorySendEmailM(listItem).build();
        responseObserver.onNext(listHistorySendEmailRes);


        responseObserver.onCompleted();
    }
}
