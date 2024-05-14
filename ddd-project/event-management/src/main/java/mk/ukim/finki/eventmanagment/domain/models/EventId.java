package mk.ukim.finki.eventmanagment.domain.models;

import lombok.NonNull;
import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;

public class EventId extends DomainObjectId {
    private EventId() {
        super(EventId.randomId(EventId.class).getId());
    }

    public EventId(@NonNull String uuid) {
        super(uuid);
    }

}
