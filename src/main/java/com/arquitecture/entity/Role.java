package com.arquitecture.entity;

import io.micronaut.data.annotation.*;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

import java.util.List;

@Serdeable
@Data
@MappedEntity
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}