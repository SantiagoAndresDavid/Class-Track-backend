package com.arquitecture.entity;

import io.micronaut.data.annotation.*;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.inject.Named;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.beans.ConstructorProperties;
import java.util.List;

@Serdeable
@Data
@MappedEntity
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Named("RoleConstructor")
    @ConstructorProperties({"name"})
    public Role(String name) {
        this.name = name;
    }
}