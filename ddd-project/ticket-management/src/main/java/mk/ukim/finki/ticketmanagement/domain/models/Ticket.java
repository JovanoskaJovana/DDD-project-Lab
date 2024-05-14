package mk.ukim.finki.ticketmanagement.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.sharedkernel.domain.financial.Money;
import mk.ukim.finki.ticketmanagement.domain.valueobjects.reservation.SeatNum;
import mk.ukim.finki.ticketmanagement.domain.valueobjects.EventId;
import mk.ukim.finki.ticketmanagement.domain.valueobjects.UserId;

@Entity
@Table (name = "ticket")
@Getter
public class Ticket extends AbstractEntity<TicketId> {

    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="price_amount")),
            @AttributeOverride(name="currency", column = @Column(name="price_currency"))
    })
    private Money price;

    private SeatNum seatNumber;

    @AttributeOverride(name = "id", column = @Column(name = "event_id", nullable = false))
    private EventId eventId;

    @AttributeOverride(name = "id", column = @Column(name = "ticket_user_id", nullable = false))
    private UserId userId;

    protected Ticket() {
        super(TicketId.randomId(TicketId.class));
    }

    public static Ticket build(Money price, SeatNum seatNumber, EventId eventId) {
        Ticket t = new Ticket();
        t.price = price;
        t.seatNumber = seatNumber;
        t.eventId = eventId;
        return t;
    }

    public void updatePriceAndSeat(Money newPrice, SeatNum newSeatNumber) {
        this.price = newPrice;
        this.seatNumber = newSeatNumber;
    }

}
