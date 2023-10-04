package com.CaseStudy.emailservice.Controller;

import com.CaseStudy.emailservice.Model.Email;
import com.CaseStudy.emailservice.Service.EmailSenderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    EmailSenderServiceImpl service;

    @PostMapping("/email/send")
    public void sendEmail(@RequestBody Email email) {
        service.sendEmail(email);
    }
}
