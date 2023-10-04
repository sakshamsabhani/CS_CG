package com.CaseStudy.reservationservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {

    private String toEmail;
    private String body;
    private String subject;

}
