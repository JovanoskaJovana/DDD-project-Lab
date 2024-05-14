package mk.ukim.finki.ticketmanagement.service.impl;

import mk.ukim.finki.sharedkernel.domain.financial.Money;
import mk.ukim.finki.ticketmanagement.domain.models.Ticket;
import mk.ukim.finki.ticketmanagement.domain.models.TicketId;
import mk.ukim.finki.ticketmanagement.domain.repository.TicketRepository;
import mk.ukim.finki.ticketmanagement.domain.valueobjects.reservation.SeatNum;
import mk.ukim.finki.ticketmanagement.domain.valueobjects.EventId;
import mk.ukim.finki.ticketmanagement.domain.valueobjects.UserId;
import mk.ukim.finki.ticketmanagement.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket createTicket(Money price, SeatNum seatNumber, EventId eventId, UserId userId) {
        Ticket ticket = Ticket.build(price, seatNumber, eventId);
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket updateTicket(String ticketId, Money price, SeatNum seatNumber) {
        Ticket ticket = ticketRepository.findById(new TicketId(ticketId))
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found with ID: " + ticketId));
        ticket.updatePriceAndSeat(price, seatNumber);
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> findAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket findTicketById(String ticketId) {
        return ticketRepository.findById(new TicketId(ticketId))
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found with ID: " + ticketId));
    }

    @Override
    public void deleteTicket(String ticketId) {
        ticketRepository.deleteById(new TicketId(ticketId));
    }
}
