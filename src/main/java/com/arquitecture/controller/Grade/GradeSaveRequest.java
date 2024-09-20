package com.arquitecture.controller.Grade;

import com.arquitecture.entity.Grade;
import com.arquitecture.entity.Statistic;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Date;

@Serdeable.Deserializable
public record GradeSaveRequest(String name, Date initialDate, Date finalDate, StatisticGradeRequest statisticGradeRequest) {
    public Grade toGrade() {
        return new Grade(name, initialDate, finalDate, statisticGradeRequest.toStatistic());
    }

    @Serdeable.Deserializable
    public record StatisticGradeRequest(
            Long id
    ) {
        public Statistic toStatistic() {
            return new Statistic(id);
        }
    }
}


