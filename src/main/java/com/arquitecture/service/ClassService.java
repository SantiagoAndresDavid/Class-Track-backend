package com.arquitecture.service;

import com.arquitecture.data.ClassRepository;
import com.arquitecture.entity.Class;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class ClassService {
    @Inject
    ClassRepository classRepository;

    public String saveClass(Class item) {
        try {
            classRepository.save(item);
            return "Class saved";
        } catch (Exception e) {
            return "Error saving class: " + e.getMessage();
        }
    }
}
