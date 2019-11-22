package com.example.schedulingtaskinspringboot.controller;

import com.example.schedulingtaskinspringboot.model.HistorySendEmail;
import com.example.schedulingtaskinspringboot.service.impl.HistorySendEmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api")
public class EmailController {


    @Autowired
    HistorySendEmailServiceImpl sendEmailService;

    @RequestMapping(value = "/history-send-email", method = RequestMethod.GET)
    public ModelAndView listHistorySendEmail(@PageableDefault(size = 5) Pageable pageable) {
        Page<HistorySendEmail> historySendEmails = sendEmailService.findAll(pageable);
        if (historySendEmails.isEmpty()){
            return new ModelAndView("error");
        }
        return new ModelAndView("list","listHistory", historySendEmails);
    }

}
