package mk.ukim.finki.ticketmanagement.domain.models;

import lombok.NonNull;
import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;

public class TicketId extends DomainObjectId {

    private TicketId() {
        super(TicketId.randomId(TicketId.class).getId());
    }

    public TicketId(@NonNull String uuid) {
        super(uuid);
    }

    public static TicketId of(String uuid) {
        TicketId t = new TicketId(uuid);
        return t;
    }



}
