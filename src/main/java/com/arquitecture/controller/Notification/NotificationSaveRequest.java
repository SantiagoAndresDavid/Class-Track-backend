package com.arquitecture.controller.Notification;

import com.arquitecture.entity.Notification;
import com.arquitecture.entity.User;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Date;
@Serdeable.Deserializable
public record NotificationSaveRequest(String name
) {
    public Notification toNotification() {
        return new Notification(name);
    }
}