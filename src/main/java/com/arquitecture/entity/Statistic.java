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
public class Statistic {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ConstructorProperties({"id"})
    public Statistic(Long id) {
        this.id = id;
    }
}
