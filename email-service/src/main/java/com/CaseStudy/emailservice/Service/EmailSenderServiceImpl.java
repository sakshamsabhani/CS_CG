package com.CaseStudy.emailservice.Service;

import com.CaseStudy.emailservice.Model.Email;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(Email email) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("hms.email.service@gmail.com");
        message.setTo(email.getToEmail());
        message.setText(email.getBody());
        message.setSubject(email.getSubject());

        mailSender.send(message);
        System.out.println("Mail Sent...");
    }

    @Override
    public void sendEmailWithAttachment(Email email, String attachment) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("spring.email.from@gmail.com");
        mimeMessageHelper.setTo(email.getToEmail());
        mimeMessageHelper.setText(email.getBody());
        mimeMessageHelper.setSubject(email.getSubject());

        FileSystemResource fileSystem = new FileSystemResource(new File(attachment));

        mimeMessageHelper.addAttachment(fileSystem.getFilename(), fileSystem);

        mailSender.send(mimeMessage);
        System.out.println("Mail Sent...");

    }
}
