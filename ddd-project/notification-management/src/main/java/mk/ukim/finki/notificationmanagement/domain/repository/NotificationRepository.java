package mk.ukim.finki.notificationmanagement.domain.repository;

import mk.ukim.finki.notificationmanagement.domain.models.Notification;
import mk.ukim.finki.notificationmanagement.domain.models.NotificationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, NotificationId> {
}
