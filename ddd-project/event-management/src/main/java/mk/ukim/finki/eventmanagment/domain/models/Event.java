package mk.ukim.finki.eventmanagment.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import mk.ukim.finki.eventmanagment.domain.valueobjects.EventDate;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;

@Entity
@Table (name = "events")
public class Event extends AbstractEntity<EventId> {

    private String name;
    private EventDate date;
    @ManyToOne
    @JoinColumn(name = "event_venueId")
    private EventVenue venue;

    @ManyToOne
    @JoinColumn(name = "event_organizerId")
    private EventOrganizer organizer;

    public Event(String name, EventDate date, EventVenue venue, EventOrganizer organizer) {
        super(EventId.randomId(EventId.class));
        this.name = name;
        this.date = date;
        this.venue = venue;
        this.organizer = organizer;
    }

    public Event() {

    }

    public void updateEventDetails(String newName, EventDate newDate) {
        this.name = newName;
        this.date = newDate;
    }

}
