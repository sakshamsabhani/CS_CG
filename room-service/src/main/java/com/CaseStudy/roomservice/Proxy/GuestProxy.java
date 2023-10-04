package com.CaseStudy.roomservice.Proxy;

import com.CaseStudy.roomservice.Model.Guest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "guest-service")
public interface GuestProxy {
    @GetMapping("/guests/inRoom/{roomNumber}")
    public List<Guest> getGuestByRoomNumber(@PathVariable int roomNumber);

    @GetMapping("/guests/find/{id}")
    public Optional<Guest> getGuest(@PathVariable int id) ;


}
