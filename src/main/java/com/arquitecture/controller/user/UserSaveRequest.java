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
        List<RoleUserRequest> roles
) {
    public User toUser() {
        List<Role> roleEntities = roles.stream()
                .map(RoleUserRequest -> new Role(RoleUserRequest.id(), RoleUserRequest.name()))
                .collect(Collectors.toList());
        return new User(name, email, password, roleEntities);
    }

    @Serdeable.Deserializable
    public record RoleUserRequest(
            Long id,
            String name
    ) {}
}