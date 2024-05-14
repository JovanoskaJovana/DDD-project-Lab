package mk.ukim.finki.eventmanagment.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;

@Entity
@Table (name = "event_venue")
public class EventVenue extends AbstractEntity<EventVenueId> {

    private String name;
    private String location;
    private int capacity;

    public EventVenue(EventVenueId eventVenueId) {

    }

    public EventVenue() {

    }
}
