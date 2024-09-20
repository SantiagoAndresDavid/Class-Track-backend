package com.arquitecture.controller.Role;

import com.arquitecture.entity.Role;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable.Deserializable
public record RoleSaveRequest(
        String name
) {
    public Role toRole() {
        return new Role(name);
    }
}