package com.example.capstone3ee.Controller;

import com.example.capstone3ee.Model.Assessment;
import com.example.capstone3ee.Model.Events;
import com.example.capstone3ee.Service.EventsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequiredArgsConstructor @RequestMapping("/api/v1/event")
public class EventsController {
    private final EventsService eventsService;

    @GetMapping("/get")
    public ResponseEntity getEvents() {
        return ResponseEntity.status(200).body(eventsService.getAllEvents());
    }

    @PostMapping("/add/{userId}")
    public ResponseEntity addEvents(@Valid @RequestBody Events events) {
        eventsService.addEvents(events);
        return ResponseEntity.status(200).body("Events added successfully");
    }

     // update

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEvents(@PathVariable int id) {
        eventsService.deleteEvents(id);
        return ResponseEntity.status(200).body("Events deleted successfully");
    }

    @PutMapping("/assign/{groupId}/{eventsId}")
    public ResponseEntity assignEventsToGroups( @PathVariable int groupId, @PathVariable Integer eventsId) {
        eventsService.assignEventToGroup(groupId,eventsId);
        return ResponseEntity.status(200).body("Events assigned successfully");
    }


          // ------------------------------ end point --------------------------------------
    @GetMapping("/durationEvents/{eventId}")
    public ResponseEntity getDurationEvents(@PathVariable int eventId) {
        return  ResponseEntity.status(200).body(eventsService.calculateEventDuration(eventId));
    }


}
