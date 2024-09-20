package com.arquitecture.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.data.annotation.sql.JoinTable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

import java.beans.ConstructorProperties;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Serdeable
@Data
@MappedEntity
public class Attendance {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;
    @JoinTable(name = "user_attendance_class")
    @Relation(value = Relation.Kind.ONE_TO_MANY, cascade = Relation.Cascade.ALL)
    private List<User> users;
    @Relation(value = Relation.Kind.ONE_TO_ONE, cascade = Relation.Cascade.ALL)
    private Grade grade;
    
    @ConstructorProperties({"date", "users", "grade"})
    public Attendance(LocalDate date, List<User> users, Grade grade) {
        this.date = date;
        this.users = users;
        this.grade = grade;
    }
}
