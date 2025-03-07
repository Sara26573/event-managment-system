package com.example.eventmanagment.Model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date reservationDate;

    private int numer_Vendesh;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private AllEvents event;

    public int getNumer_Vendesh() {
        return numer_Vendesh;
    }

    public void setNumer_Vendesh(int numer_Vendesh) {
        this.numer_Vendesh = numer_Vendesh;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AllEvents getEvent() {
        return event;
    }

    public void setEvent(AllEvents event) {
        this.event = event;
    }
}
