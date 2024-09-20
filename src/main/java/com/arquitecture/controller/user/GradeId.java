package com.arquitecture.controller.user;

import com.arquitecture.entity.Grade;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable.Deserializable
public record GradeId(Long id) {
    public Grade toGrade() {
        return new Grade(this.id);
    }
}
