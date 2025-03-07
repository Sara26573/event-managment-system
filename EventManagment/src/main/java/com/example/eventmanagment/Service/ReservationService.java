package com.example.eventmanagment.Service;

import com.example.eventmanagment.Dto.ReservationDTO;
import com.example.eventmanagment.Dto.ReservationSeatsDTO;
import com.example.eventmanagment.Model.AllEvents;
import com.example.eventmanagment.Model.Reservation;
import com.example.eventmanagment.Model.User;
import com.example.eventmanagment.Repository.EventRepository;
import com.example.eventmanagment.Repository.ReservationRepository;
import com.example.eventmanagment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;
    private UserRepository userRepository;
    private EventRepository eventRepository;

    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository, EventRepository eventRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }


    public Reservation makeReservation(ReservationDTO reservationDTO) {

        Optional<User> optionalUser = userRepository.findById(reservationDTO.getUser_id());
        if(!optionalUser.isPresent()){
            throw new RuntimeException("User not found");
        }
        User user = optionalUser.get();

        Optional<AllEvents> optionalEvent = eventRepository.findById(reservationDTO.getEvent_id());
        if(!optionalEvent.isPresent()){
            throw new RuntimeException("Event not found");
        }
        AllEvents allEvents = optionalEvent.get();

        if(allEvents.getSeats() - reservationDTO.getNumer_Vendesh()  <= 0){
            throw new RuntimeException("No seats available(Rezervimi nuk mund te behet)");
        }

        else{
            allEvents.setSeats(allEvents.getSeats() - reservationDTO.getNumer_Vendesh());
        }

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setEvent(allEvents);
        reservation.setReservationDate(reservationDTO.getReservation_date());
        reservation.setNumer_Vendesh(reservationDTO.getNumer_Vendesh());

        reservationRepository.save(reservation);
        return reservation;

    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation updateReservationMethod(Long reservationId, ReservationSeatsDTO reservationSeatsDTO) {

        Optional<Reservation> existingReservationOptional = reservationRepository.findById(reservationId);
        if (!existingReservationOptional.isPresent()) {
            throw new RuntimeException("Reservation not found");
        }

        Reservation existingReservation = existingReservationOptional.get();

        Optional<AllEvents> optionalEvent = eventRepository.findById(reservationSeatsDTO.getEvent_id());

        if (!optionalEvent.isPresent()) {
            throw new RuntimeException("Event not found");
        }
        AllEvents allEvents = optionalEvent.get();

        if(allEvents.getSeats() - reservationSeatsDTO.getNumer_Vendesh()  <= 0){
            throw new RuntimeException("No seats available(Rezervimi nuk mund te behet)");
        }

        else{

            if((existingReservation.getNumer_Vendesh() - reservationSeatsDTO.getNumer_Vendesh())>0)
            {
                allEvents.setSeats(allEvents.getSeats() + (existingReservation.getNumer_Vendesh() - reservationSeatsDTO.getNumer_Vendesh()));
            }
            else if((existingReservation.getNumer_Vendesh() - reservationSeatsDTO.getNumer_Vendesh())<0)
            {
                allEvents.setSeats(allEvents.getSeats() - (Math.abs(existingReservation.getNumer_Vendesh() - reservationSeatsDTO.getNumer_Vendesh())));

            }
        }

        existingReservation.setNumer_Vendesh(reservationSeatsDTO.getNumer_Vendesh());
        existingReservation.setEvent(allEvents);
        return reservationRepository.save(existingReservation);
    }

    public Reservation deleteReservation(Long reservationID) {
        Optional<Reservation> reservationPresent = reservationRepository.findById(reservationID);
        if(!reservationPresent.isPresent()){
            throw new RuntimeException("Reservation not found");
        }
        Reservation reservation = reservationPresent.get();
        if(reservationPresent.isPresent()){
            reservation.getEvent().setSeats(reservation.getNumer_Vendesh() +  reservation.getEvent().getSeats());
            reservationRepository.deleteById(reservationID);
        }

        return reservation;
    }
}
