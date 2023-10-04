package com.CaseStudy.guestservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface RoomProxy {

    @GetMapping("/rooms/{roomNumber}")
    public Room retrieveRoomDetails(@PathVariable int roomNumber);
}
