package mk.ukim.finki.notificationmanagement.service;

import mk.ukim.finki.notificationmanagement.domain.models.Notification;
import mk.ukim.finki.notificationmanagement.domain.valueobjects.UserId;

import java.util.List;

public interface NotificationService {
    Notification createNotification(UserId userId, String type, String status, String content);
    Notification updateNotification(String notificationId, String status);
    List<Notification> findAllNotifications();
    Notification findNotificationById(String notificationId);
    void deleteNotification(String notificationId);
}
