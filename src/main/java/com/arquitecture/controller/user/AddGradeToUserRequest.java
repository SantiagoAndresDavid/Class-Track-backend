package com.arquitecture.controller.user;



import com.arquitecture.entity.Grade;
import com.arquitecture.entity.User;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable.Deserializable
public record AddGradeToUserRequest(Long id, List<GradeId> grades) {
}

