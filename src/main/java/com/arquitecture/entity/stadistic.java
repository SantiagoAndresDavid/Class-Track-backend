package com.arquitecture.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

@Serdeable
@Data
@MappedEntity
public class stadistic {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
