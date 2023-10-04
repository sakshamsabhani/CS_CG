package com.CaseStudy.reservationservice.Proxy;

import com.CaseStudy.reservationservice.Model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "room-service")
public interface RoomProxy {

    @GetMapping("/rooms/{roomNumber}")
    public Room retrieveRoomDetails(@PathVariable int roomNumber);

    @GetMapping("/rooms/check/{roomNumber}")
    public boolean roomAvailability(@PathVariable int roomNumber);

    @PutMapping("/rooms/update")
    public void updateRoom(@RequestBody Room room);
}
