package mk.ukim.finki.notificationmanagement.service.impl;

import mk.ukim.finki.notificationmanagement.domain.models.Notification;
import mk.ukim.finki.notificationmanagement.domain.models.NotificationId;
import mk.ukim.finki.notificationmanagement.domain.repository.NotificationRepository;
import mk.ukim.finki.notificationmanagement.domain.valueobjects.UserId;
import mk.ukim.finki.notificationmanagement.service.NotificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification createNotification(UserId userId, String type, String status, String content) {
        Notification notification = Notification.build(userId, type, status, content);
        return notificationRepository.save(notification);
    }

    @Override
    public Notification updateNotification(String notificationId, String status) {
        Notification notification = notificationRepository.findById(new NotificationId(notificationId))
                .orElseThrow(() -> new IllegalArgumentException("Notification not found with ID: " + notificationId));
        notification.updateStatus(status);
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> findAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification findNotificationById(String notificationId) {
        return notificationRepository.findById(new NotificationId(notificationId))
                .orElseThrow(() -> new IllegalArgumentException("Notification not found with ID: " + notificationId));
    }

    @Override
    public void deleteNotification(String notificationId) {
        notificationRepository.deleteById(new NotificationId(notificationId));
    }
}
