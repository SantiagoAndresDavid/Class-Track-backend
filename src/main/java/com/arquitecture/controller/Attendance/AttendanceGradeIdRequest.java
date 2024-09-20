package com.arquitecture.controller.Attendance;

import com.arquitecture.entity.Grade;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable.Deserializable
public record AttendanceGradeIdRequest(Long id) {
    public Grade toGrade() {
        return new Grade(id);
    }
}
