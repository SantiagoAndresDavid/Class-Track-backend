package com.arquitecture.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

import java.util.List;

@Serdeable
@Data
@MappedEntity
public class Class {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Relation(value = Relation.Kind.ONE_TO_MANY, cascade = Relation.Cascade.ALL)
    private List<Notification> notifications;
    @Relation(value = Relation.Kind.ONE_TO_ONE, cascade = Relation.Cascade.ALL)
    private stadistic stadistic;
}
