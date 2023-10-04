package com.CaseStudy.roomservice.Repository;

import com.CaseStudy.roomservice.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, String> {

    Room findByRoomNumber(int roomNumber);
    List<Room> findByRoomType(String roomType);
}
