package com.arquitecture.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

import java.beans.ConstructorProperties;

@Serdeable
@Data
@MappedEntity
public class Notification {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ConstructorProperties({"name"})
    public Notification(String name) {
        this.name = name;
    }
}
