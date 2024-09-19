package com.arquitecture.data;

import com.arquitecture.entity.Notification;
import io.micronaut.data.repository.CrudRepository;

public interface NotificationRepository extends CrudRepository<Notification, Long> {
}
