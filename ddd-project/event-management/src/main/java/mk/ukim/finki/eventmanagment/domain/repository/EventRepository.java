package mk.ukim.finki.eventmanagment.domain.repository;

import mk.ukim.finki.eventmanagment.domain.models.Event;
import mk.ukim.finki.eventmanagment.domain.models.EventId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, EventId> {
}
