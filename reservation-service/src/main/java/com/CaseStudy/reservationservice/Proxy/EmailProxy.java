package com.CaseStudy.reservationservice.Proxy;

import com.CaseStudy.reservationservice.Model.Email;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "email-service")
public interface EmailProxy {
    @PostMapping("/email/send")
    public void sendEmail(@RequestBody Email email);
}
