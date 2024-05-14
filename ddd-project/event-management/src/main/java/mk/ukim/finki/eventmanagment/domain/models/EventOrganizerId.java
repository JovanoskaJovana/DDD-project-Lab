package mk.ukim.finki.eventmanagment.domain.models;

import lombok.NonNull;
import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;

public class EventOrganizerId extends DomainObjectId {
    private EventOrganizerId() {
        super(EventOrganizerId.randomId(EventOrganizerId.class).getId());
    }

    public EventOrganizerId(@NonNull String uuid) {
        super(uuid);
    }

}
