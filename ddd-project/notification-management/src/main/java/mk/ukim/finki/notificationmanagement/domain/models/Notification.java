package mk.ukim.finki.notificationmanagement.domain.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.notificationmanagement.domain.valueobjects.UserId;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;

@Entity
@Table (name = "notifications")
@Getter
public class Notification extends AbstractEntity<NotificationId> {

    private String type;

    private String status;

    private String content;

    @AttributeOverride(name = "id", column = @Column(name = "ticket_user_id", nullable = false))
    private UserId userId;

    protected Notification() {
        super(NotificationId.randomId(NotificationId.class));
    }

    public static Notification build(UserId userId, String type, String status, String content) {
        Notification notification = new Notification();
        notification.userId = userId;
        notification.type = type;
        notification.status = status;
        notification.content = content;
        return notification;
    }

    public void updateStatus(String status) {
        this.status = status;
    }

}
