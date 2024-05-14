package mk.ukim.finki.eventmanagment.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;

@Entity
@Table(name = "event_organizer")
public class EventOrganizer extends AbstractEntity<EventOrganizerId> {

    private String name;
    private String contact;

    public EventOrganizer(EventOrganizerId eventOrganizerId) {

    }

    public EventOrganizer() {

    }
}
