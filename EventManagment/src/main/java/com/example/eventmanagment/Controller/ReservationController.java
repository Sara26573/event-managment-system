package com.example.eventmanagment.Controller;


import com.example.eventmanagment.Dto.ReservationDTO;
import com.example.eventmanagment.Dto.ReservationSeatsDTO;
import com.example.eventmanagment.Model.Reservation;
import com.example.eventmanagment.Service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    private ReservationService reservationService;
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;

    }

    @DeleteMapping("/{id}")
    public Reservation deleteReservation(@PathVariable Long id) {
        System.out.println("deleted");
        return reservationService.deleteReservation(id);
    }

    @PostMapping()
    public Reservation makeReservation(@RequestBody ReservationDTO reservationDTO) {
        return reservationService.makeReservation(reservationDTO);

    }

    @GetMapping()
    public List<Reservation> getReservations() {
        return reservationService.getAllReservations();
    }

    @PutMapping("/{reservationid}")
    public Reservation updateReservation(@PathVariable Long reservationid, @RequestBody ReservationSeatsDTO reservationSeatsDTO) {
        return reservationService.updateReservationMethod(reservationid, reservationSeatsDTO);
    }

}
