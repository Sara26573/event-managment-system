package com.example.eventmanagment.Repository;

import com.example.eventmanagment.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {


}
