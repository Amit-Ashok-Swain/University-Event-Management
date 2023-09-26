package com.geekster.project.assignment.UniversityEventManagement.Controller;

import com.geekster.project.assignment.UniversityEventManagement.Model.Event;
import com.geekster.project.assignment.UniversityEventManagement.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

@RestController
public class EventController {
    @Autowired
    EventService eventService;
    @PostMapping("event")
    public String addAEvent(@RequestBody Event e){
        return eventService.addAEvent(e);
    }
    @PostMapping("events")
    public String addEvents(@RequestBody List<Event> e){
        return eventService.addEvents(e);
    }
    @GetMapping("events")
    public Iterable<Event> getAllEvents(){
        return eventService.getAllEvents();
    }
    @GetMapping("event/{id}")
    public Optional<Event> getEventById(@PathVariable Integer id){
        return eventService.getEventById(id);
    }
    @GetMapping("events/date")
    public Iterable<Event> getEventsOnSameDate(@RequestParam LocalDate date){
        return eventService.getEventsOnSameDate(date);
    }
    @PutMapping("event/id/{id}/location/{loc}")
    public String updateEventLocationById(@PathVariable Integer id, @PathVariable String loc){
        return eventService.updateEventLocationById(id, loc);
    }
    @DeleteMapping("event/{id}")
    public String removeEventById(@PathVariable Integer id){
        return eventService.removeEventById(id);
    }
}

/*
Add event
Update event
Delete event
Get All events by date
 */