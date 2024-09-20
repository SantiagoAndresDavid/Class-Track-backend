package com.arquitecture.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

import java.beans.ConstructorProperties;
import java.util.Date;
import java.util.List;

@Serdeable
@Data
@MappedEntity
public class Grade {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Date initialDate;
    private Date finalDate;
    @Relation(value = Relation.Kind.ONE_TO_MANY, cascade = Relation.Cascade.ALL)
    private List<Notification> notifications;
    @Relation(value = Relation.Kind.ONE_TO_ONE, cascade = Relation.Cascade.ALL)
    private Statistic statistic;

    @ConstructorProperties({"name", "initialDate", "finalDate", "statistic"})
    public Grade(String name, Date initialDate, Date finalDate, Statistic statistic) {
        this.name = name;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.statistic = statistic;
    }

    @ConstructorProperties({"id"})
    public Grade(Long id) {
        this.id = id;
    }
}
