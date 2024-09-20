package com.arquitecture.controller.user;

import com.arquitecture.entity.Role;
import com.arquitecture.entity.User;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;
import java.util.stream.Collectors;

@Serdeable.Deserializable
public record UserSaveRequest(
        String name,
        String email,
        String password,
        List<RoleRequest> roles
) {
    public User toUser() {
        List<Role> roleEntities = roles.stream()
                .map(roleRequest -> new Role(roleRequest.id(), roleRequest.name()))
                .collect(Collectors.toList());
        return new User(name, email, password, roleEntities);
    }

    @Serdeable.Deserializable
    public record RoleRequest(
            Long id,
            String name
    ) {}
}