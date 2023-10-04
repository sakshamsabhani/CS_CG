package com.CaseStudy.emailservice.Service;

import com.CaseStudy.emailservice.Model.Email;
import jakarta.mail.MessagingException;

public interface EmailSenderService {

    public void sendEmail(Email email);
    public void sendEmailWithAttachment(Email email, String attachment) throws MessagingException;
    }
