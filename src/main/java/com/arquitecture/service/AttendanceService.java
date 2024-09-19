package com.arquitecture.service;

import com.arquitecture.data.AttendanceRepository;
import com.arquitecture.entity.Attendance;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class AttendanceService {
    @Inject
    AttendanceRepository attendanceRepository;

    public String saveAttendance(Attendance attendance) {
        try {
            attendanceRepository.save(attendance);
            return "Attendance saved";
        } catch (Exception e) {
            return "Error saving attendance: " + e.getMessage();
        }
    }

}
