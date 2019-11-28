package com.example.schedulingtaskinspringboot.controller;

import com.example.grpc.EmailServiceGrpc;

import com.example.grpc.ListHistorySendEmailReq;
import com.example.grpc.ListHistorySendEmailRes;
import com.example.schedulingtaskinspringboot.model.HistorySendEmail;
import com.example.schedulingtaskinspringboot.service.impl.HistorySendEmailServiceImpl;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@GRpcService
public class TaskGrpcController extends EmailServiceGrpc.EmailServiceImplBase {

    @Autowired
    HistorySendEmailServiceImpl sendEmailService;

    @Override
    public void readAllHistorySendEmail(ListHistorySendEmailReq request, StreamObserver<ListHistorySendEmailRes> responseObserver) {
        List<HistorySendEmail> historySendEmails = sendEmailService.findAllHistory();
        for (HistorySendEmail historySendEmail : historySendEmails) {
            String message = "SendEmail: " + historySendEmail.getSendEmail().getUsername() +
                    ", Title: " + historySendEmail.getTitle() +
                    ", Status: " + historySendEmail.getStatus() +
                    ", ReceiveEmail: " + historySendEmail.getReceiveEmail().getEmail() +
                    ", Time: " + historySendEmail.getTime();

            ListHistorySendEmailRes listHistorySendEmailRes = ListHistorySendEmailRes.newBuilder().setMessage(message).build();
            responseObserver.onNext(listHistorySendEmailRes);
        }


        responseObserver.onCompleted();
    }
}
