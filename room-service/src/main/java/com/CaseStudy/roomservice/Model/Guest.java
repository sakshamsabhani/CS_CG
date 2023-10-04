package com.CaseStudy.roomservice.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Guest {
    private String guestId;
    private String guestName;
    private String email;
    private String phoneNumber;
    private String address;
}