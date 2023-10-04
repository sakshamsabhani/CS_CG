package com.CaseStudy.guestservice.Proxy;

import com.CaseStudy.guestservice.Model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "room-service")
public interface RoomProxy {

    @GetMapping("/rooms/{roomNumber}")
    public Room retrieveRoomDetails(@PathVariable int roomNumber);
}
