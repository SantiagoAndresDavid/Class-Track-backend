package com.arquitecture.entity;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.data.annotation.sql.JoinTable;
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
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String password;
    //https://stackoverflow.com/questions/76532241/micronaut-jdbc-many-to-many-relationship
    @JoinTable(name = "user_role")
    @Relation(value = Relation.Kind.MANY_TO_MANY, cascade = Relation.Cascade.ALL)
    private List<Role> roles;
    @JoinTable(name = "schedule")
    @Relation(value = Relation.Kind.MANY_TO_MANY, cascade = Relation.Cascade.ALL)
    private List<Grade> grades;


    @ConstructorProperties({"name", "email", "password", "roles"})
    public User(String name, String email, String password, @Nullable List<Role> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    @ConstructorProperties({"name", "email", "password", "roles", "grades"})
    public User(String name, String email, String password, @Nullable List<Role> roles, @Nullable List<Grade> grades) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.grades = grades;
    }
    @ConstructorProperties({"id"})
    public User(Long id) {
        this.id = id;
    }
}