package com.example.eventmanagment.Controller;

import com.example.eventmanagment.Model.AllEvents;
import com.example.eventmanagment.Service.EventService;
import com.example.eventmanagment.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventsController {


    private final EventService eventService;

    public EventsController(EventService eventService, UserService userService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<AllEvents> getAllEvents() {
        return eventService.getallEvents();
    }

    @GetMapping("/{id}")
    public AllEvents getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @PostMapping
    public AllEvents createEvent(@RequestBody AllEvents eventOne) {
         return eventService.createEvent(eventOne);
    }

    @DeleteMapping("/{id}")
    public List<AllEvents> deleteEvent(@PathVariable Long id) {
        return eventService.deleteEvent(id);
    }

    @PutMapping("/{id}")
    public AllEvents updateEvent(@PathVariable Long id, @RequestBody AllEvents eventOne) {
        eventOne.setId(id);
        return eventService.updateEvent(eventOne);
    }
}
