package com.geekster.project.assignment.UniversityEventManagement.Service;

import com.geekster.project.assignment.UniversityEventManagement.Model.Event;
import com.geekster.project.assignment.UniversityEventManagement.Repository.IEventRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    IEventRepo eventRepo;


    public  String addAEvent(Event e){
        eventRepo.save(e);
        return "A new event is added !!!";
    }

    public String addEvents(List<Event> e){
        eventRepo.saveAll(e);
        return "List of events are added !!!";
    }

    public Iterable<Event> getAllEvents(){
        return eventRepo.findAll();
    }

    public Optional<Event> getEventById(Integer id){
        return eventRepo.findById(id);
    }

    public Iterable<Event> getEventsOnSameDate(LocalDate date){
        return eventRepo.findByEventDate(date);
    }

    public String updateEventLocationById(Integer id, String loc){
        Optional<Event> s = eventRepo.findById(id);

        if(s.isEmpty()){
           return "Event not found !!!";
        }

        Event e = s.get();
        e.setLocationOfEvent(loc);
        eventRepo.save(e);
        return "Location updated for the provided event";
    }

    public String removeEventById(Integer id){
        Event e = eventRepo.findById(id).orElse(null);

        if(e==null){
            return "Id not found";
        }

        eventRepo.delete(e);

        return "Event is removed !!!";
    }

}
