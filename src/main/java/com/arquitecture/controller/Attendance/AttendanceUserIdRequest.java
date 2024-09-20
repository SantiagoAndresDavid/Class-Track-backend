package com.arquitecture.controller.Attendance;

import com.arquitecture.entity.User;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable.Deserializable
public record AttendanceUserIdRequest(Long id) {
    public User toUser() {
        return new User(id);
    }
}
