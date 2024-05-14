package mk.ukim.finki.eventmanagment.service.impl;

import mk.ukim.finki.eventmanagment.domain.models.Event;
import mk.ukim.finki.eventmanagment.domain.repository.EventRepository;
import mk.ukim.finki.eventmanagment.domain.valueobjects.EventDate;
import mk.ukim.finki.eventmanagment.service.EventService;
import org.springframework.stereotype.Service;
import mk.ukim.finki.eventmanagment.domain.models.EventVenue;
import mk.ukim.finki.eventmanagment.domain.models.EventOrganizer;
import mk.ukim.finki.eventmanagment.domain.models.EventVenueId;
import mk.ukim.finki.eventmanagment.domain.models.EventOrganizerId;
import mk.ukim.finki.eventmanagment.domain.models.EventId;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    public final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Override
    public Event createEvent(String name, EventDate date, String venueId, String organizerId) {
        EventVenue venue = new EventVenue(new EventVenueId(venueId));
        EventOrganizer organizer = new EventOrganizer(new EventOrganizerId(organizerId));
        Event event = new Event(name, date, venue, organizer);
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(String eventId, String newName, EventDate newDate) {
        Event event = eventRepository.findById(new EventId(eventId))
                .orElseThrow(() -> new IllegalArgumentException("Invalid event ID"));
        event.updateEventDetails(newName, newDate);
        return eventRepository.save(event);
    }

    @Override
    public List<Event> listAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public boolean cancelEvent(String eventId) {
        eventRepository.deleteById(new EventId(eventId));
        return true;
    }
}
