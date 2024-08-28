package com.example.capstone3ee.Service;

import com.example.capstone3ee.Api.ApiException;
import com.example.capstone3ee.Model.Events;
import com.example.capstone3ee.Model.Groups;
import com.example.capstone3ee.Model.User;
import com.example.capstone3ee.Repository.EventsRepository;
import com.example.capstone3ee.Repository.GroupsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service @RequiredArgsConstructor
public class EventsService {
    private final EventsRepository eventsRepository;
    private final GroupsRepository groupsRepository;

    public List<Events> getAllEvents() {
       return eventsRepository.findAll();
    }

    public void addEvents(Events events) {
        eventsRepository.save(events);
    }

    public void deleteEvents(Integer id) {
        Events events = eventsRepository.findEventsById(id);
        if (events == null) {
            throw new ApiException("No events with id " + id + " found");
        }
        eventsRepository.delete(events);
    }


//    public void updateEvents(Events events) {
//
//    }



    public void assignEventToGroup(Integer groupId, Integer eventId) {
        Groups group = groupsRepository.findGroupByGroupId(groupId);
        Events event = eventsRepository.findEventsById(eventId);

        if (group == null) {
            throw new ApiException("No group with id " + groupId + " found");
        }

        if (event == null) {
            throw new ApiException("No event with id " + eventId + " found");
        }

        group.getEvents().add(event);
        groupsRepository.save(group);
    }

    // --------------------------------- end points -------------------------------------

    // calculate duration of event  : by Nora
    public Duration calculateEventDuration(Integer eventId) {
        Events event = eventsRepository.findEventsById(eventId);
        if (event.getStartDate() != null && event.getEndDate() != null) {
            return Duration.between(event.getStartDate(), event.getEndDate());
        } else {
            return Duration.ZERO;
        }




    }




}
