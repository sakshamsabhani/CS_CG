package com.CaseStudy.guestservice.Repository;

import com.CaseStudy.guestservice.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findByRoomNumber(int roomNumber);
    Optional<Room> findByRoomType(String roomType);
}
