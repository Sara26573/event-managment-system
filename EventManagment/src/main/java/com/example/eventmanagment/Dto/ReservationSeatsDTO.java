package com.example.eventmanagment.Dto;

public class ReservationSeatsDTO {

    private Long event_id;
    private int numer_Vendesh;

    public ReservationSeatsDTO(Long event_id, int numer_Vendesh) {


        this.event_id = event_id;
        this.numer_Vendesh = numer_Vendesh;
    }

    public int getNumer_Vendesh() {
        return numer_Vendesh;
    }

    public void setNumer_Vendesh(int numer_Vendesh) {
        this.numer_Vendesh = numer_Vendesh;
    }

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }
}
