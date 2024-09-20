package com.arquitecture.controller.Attendance;

import com.arquitecture.service.AttendanceService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;

@Controller("/attendance")
@Tag(name = "Attendance")
public class AttendanceController {
    @Inject
    AttendanceService attendanceService;

    @Post("/save")
    @Produces(MediaType.APPLICATION_JSON)
    public String saveAttendance(AttendanceSaveRequest attendanceSaveRequest) {
        return attendanceService.saveAttendance(attendanceSaveRequest.toAttendance());
    }
}
