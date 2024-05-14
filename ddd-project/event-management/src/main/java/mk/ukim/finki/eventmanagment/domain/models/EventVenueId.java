package mk.ukim.finki.eventmanagment.domain.models;

import lombok.NonNull;
import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;

public class EventVenueId extends DomainObjectId{
    private EventVenueId() {
        super(EventVenueId.randomId(EventVenueId.class).getId());
    }

    public EventVenueId(@NonNull String uuid) {
        super(uuid);
    }

}
