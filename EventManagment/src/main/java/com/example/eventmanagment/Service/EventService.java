package com.example.eventmanagment.Service;

import com.example.eventmanagment.Model.AllEvents;
import com.example.eventmanagment.Repository.EventRepository;
import com.example.eventmanagment.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
    }

    public List<AllEvents> getallEvents() {
        return eventRepository.findAll();
    }

    public AllEvents getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public AllEvents createEvent(AllEvents eventOne) {
        return eventRepository.save(eventOne);
    }

    public List<AllEvents>  deleteEvent(Long id) {
        eventRepository.deleteById(id);
        return eventRepository.findAll();
    }

    public AllEvents updateEvent(AllEvents eventOne) {
        Optional<AllEvents> existingEvent = eventRepository.findById(eventOne.getId());



            AllEvents updatedEvent = existingEvent.get();
            updatedEvent.setEventName(eventOne.getEventName());
            updatedEvent.setDescription(eventOne.getDescription());
            updatedEvent.setLocation(eventOne.getLocation());
            updatedEvent.setCategory(eventOne.getCategory());
            updatedEvent.setDate(eventOne.getDate());
            updatedEvent.setSeats(eventOne.getSeats());


            return eventRepository.save(updatedEvent);
         }


}
