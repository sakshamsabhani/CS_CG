package com.CaseStudy.guestservice.Repository;

import com.CaseStudy.guestservice.Model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer>{

    List<Guest> findByRoomNumber(int roomNumber);

    Guest findByGuestId(int guestId);

}
