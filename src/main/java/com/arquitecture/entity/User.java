package com.arquitecture.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.data.annotation.sql.JoinColumn;
import io.micronaut.data.annotation.sql.JoinTable;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

import java.util.List;

@Serdeable
@Data
@MappedEntity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String password;
    //https://stackoverflow.com/questions/76532241/micronaut-jdbc-many-to-many-relationship
    @Relation(value = Relation.Kind.MANY_TO_MANY, cascade = Relation.Cascade.ALL)
    private List<Role> roles;
}