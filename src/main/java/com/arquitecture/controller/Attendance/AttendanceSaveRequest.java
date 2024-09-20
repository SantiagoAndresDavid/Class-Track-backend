package com.arquitecture.controller.Attendance;

import com.arquitecture.entity.Attendance;
import com.arquitecture.entity.Grade;
import com.arquitecture.entity.User;
import io.micronaut.serde.annotation.Serdeable;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Serdeable.Deserializable
public record AttendanceSaveRequest(List<AttendanceUserIdRequest> users, AttendanceGradeIdRequest gradeId, LocalDate attendanceDate) {
    public Attendance toAttendance() {
        List<User> userEntities = users.stream()
                .map(UserIdRequest -> new User(UserIdRequest.id()))
                .collect(Collectors.toList());
        return new Attendance(attendanceDate, userEntities, gradeId.toGrade());
    }
}