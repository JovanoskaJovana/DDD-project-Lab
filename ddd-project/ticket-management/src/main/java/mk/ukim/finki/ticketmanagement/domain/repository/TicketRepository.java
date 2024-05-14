package mk.ukim.finki.ticketmanagement.domain.repository;

import mk.ukim.finki.ticketmanagement.domain.models.Ticket;
import mk.ukim.finki.ticketmanagement.domain.models.TicketId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, TicketId> {
}
