package mk.ukim.finki.ticketmanagement.service;

import mk.ukim.finki.sharedkernel.domain.financial.Money;
import mk.ukim.finki.ticketmanagement.domain.models.Ticket;
import mk.ukim.finki.ticketmanagement.domain.valueobjects.reservation.SeatNum;
import mk.ukim.finki.ticketmanagement.domain.valueobjects.EventId;
import mk.ukim.finki.ticketmanagement.domain.valueobjects.UserId;

import java.util.List;

public interface TicketService {
    Ticket createTicket(Money price, SeatNum seatNumber, EventId eventId, UserId userId);
    Ticket updateTicket(String ticketId, Money price, SeatNum seatNumber);
    List<Ticket> findAllTickets();
    Ticket findTicketById(String ticketId);
    void deleteTicket(String ticketId);
}
