package com.CaseStudy.guestservice.Repository;

import com.CaseStudy.guestservice.GuestTemplate.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestSpringDataJpaRepository extends JpaRepository<Guest, Integer>{
    Optional<Guest> findByGuestName(String guestName);

}
