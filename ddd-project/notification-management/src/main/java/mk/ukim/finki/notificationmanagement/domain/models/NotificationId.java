package mk.ukim.finki.notificationmanagement.domain.models;

import lombok.NonNull;
import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;

public class NotificationId extends DomainObjectId {

    private NotificationId() {
        super(NotificationId.randomId(NotificationId.class).getId());
    }

    public NotificationId(@NonNull String uuid) {
        super(uuid);
    }

    public static NotificationId of(String uuid) {
        NotificationId n = new NotificationId(uuid);
        return n;
    }
}
