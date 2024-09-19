package com.arquitecture.service;

import com.arquitecture.data.NotificationRepository;
import com.arquitecture.entity.Notification;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class NotificationService {
    @Inject
    NotificationRepository notificationRepository;


    public String createNotification(Notification notification) {
        try {
            notificationRepository.save(notification);
            return "Notification saved";
        } catch (Exception e) {
            return "Error saving notification: " + e.getMessage();
        }
    }
}
