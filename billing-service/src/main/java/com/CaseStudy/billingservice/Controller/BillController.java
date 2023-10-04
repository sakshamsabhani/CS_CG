package com.CaseStudy.billingservice.Controller;

import com.CaseStudy.billingservice.Service.BillService;
import com.CaseStudy.billingservice.Model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {

    @Autowired
    BillService service;

    @GetMapping("/bill/generate/{bookingId}")
    public Bill generateBill(@PathVariable String bookingId){
        return service.generateBill(bookingId);
    }

}
