package mk.ukim.finki.eventmanagment.service;

import mk.ukim.finki.eventmanagment.domain.models.Event;
import mk.ukim.finki.eventmanagment.domain.valueobjects.EventDate;

import java.util.List;

public interface EventService {
    Event createEvent(String name, EventDate date, String venueId, String organizerId);
    Event updateEvent(String eventId, String newName, EventDate newDate);
    List<Event> listAllEvents();
    boolean cancelEvent(String eventId);
}
