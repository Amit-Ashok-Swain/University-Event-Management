package com.geekster.project.assignment.UniversityEventManagement.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Event")
public class Event {
    @Id
    private Integer  eventId;

    private String eventName;

    private String locationOfEvent;

    private LocalDate eventDate;

    private LocalTime startTime;

    private LocalTime endTime;

}

/*Event Model will have
eventId
eventName
locationOfEvent
date
startTime
endTime*/
