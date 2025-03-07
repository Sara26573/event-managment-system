package com.example.eventmanagment.Dto;

import java.util.Date;

public class ReservationDTO {
    private Long user_id;
    private Date reservation_date;
    private Long event_id;
    private int numer_Vendesh;

    public ReservationDTO(Long user_id, Date reservation_date, Long event_id, int numer_Vendesh) {
        this.user_id = user_id;
        this.reservation_date = reservation_date;
        this.event_id = event_id;
        this.numer_Vendesh = numer_Vendesh;
    }

    public int getNumer_Vendesh() {
        return numer_Vendesh;
    }

    public void setNumer_Vendesh(int numer_Vendesh) {
        this.numer_Vendesh = numer_Vendesh;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }


    public Date getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(Date reservation_date) {
        this.reservation_date = reservation_date;
    }

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }
}
