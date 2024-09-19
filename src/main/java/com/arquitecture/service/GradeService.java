package com.arquitecture.service;


import com.arquitecture.data.GradeRepository;
import com.arquitecture.entity.Grade;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class GradeService {
    @Inject
    GradeRepository gradeRepository;

    public String saveClass(Grade grade) {
        try {
            gradeRepository.save(grade);
            return "Class saved";
        } catch (Exception e) {
            return "Error saving class: " + e.getMessage();
        }
    }
}
