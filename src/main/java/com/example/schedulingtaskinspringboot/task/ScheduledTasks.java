package com.example.schedulingtaskinspringboot.task;

import com.example.schedulingtaskinspringboot.model.HistorySendEmail;
import com.example.schedulingtaskinspringboot.model.ReceiveEmail;
import com.example.schedulingtaskinspringboot.model.SendEmail;
import com.example.schedulingtaskinspringboot.service.impl.HistorySendEmailServiceImpl;
import com.example.schedulingtaskinspringboot.service.impl.ReceiveEmailServiceImpl;
import com.example.schedulingtaskinspringboot.service.impl.SendEmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduledTasks {

    @Autowired
    SendEmailServiceImpl sendEmailService;

    @Autowired
    ReceiveEmailServiceImpl receiveEmailService;

    @Autowired
    HistorySendEmailServiceImpl historySendEmailService;

    @Scheduled(cron = "0 47 16 * * MON-FRI")
    public void planBedTime() {
        EmailUtils emailUtils = new EmailUtils();
        emailUtils.sendEmail("nhac nho di ngu ", "di ngu th, di ngu th", "ledung276276@gmail.com");
        saveScheduler("nhac nho di ngu ", "di ngu th, di ngu th",
                "ledung276276@gmail.com", LocalDateTime.now(), "thanh cong");
        System.out.println("ok");
    }

    @Scheduled(cron = "0 46 16 * * MON-FRI")
    public void planTimeToWakeUp() {
        EmailUtils emailUtils = new EmailUtils();
        emailUtils.sendEmail("nhac nho thuc day ", "day di th, day di th", "ledung276276@gmail.com");
        saveScheduler("nhac nho thuc day ", "day di th, day di th",
                "ledung276276@gmail.com", LocalDateTime.now(), "thanh cong");
        System.out.println("ok");
    }

    private void saveScheduler(String title, String context, String toAddress, LocalDateTime time, String status) {
        SendEmail sendEmail = new SendEmail();
        sendEmail.setUsername("santafe9xyb@gmail.com");
        sendEmail.setPassword("santafe9xyb@gmail.com");
        sendEmail.setTitle(title);
        sendEmail.setContent(context);
        sendEmailService.save(sendEmail);

        ReceiveEmail receiveEmail = new ReceiveEmail();
        receiveEmail.setEmail(toAddress);
        receiveEmail.setSendEmail(sendEmail);
        receiveEmailService.save(receiveEmail);

        HistorySendEmail historySendEmail = new HistorySendEmail();
        historySendEmail.setSendEmail(sendEmail);
        historySendEmail.setReceiveEmail(receiveEmail);
        historySendEmail.setTitle(title);
        historySendEmail.setContent(context);
        historySendEmail.setTime(time);
        historySendEmail.setStatus(status);
        historySendEmailService.save(historySendEmail);

    }


}
