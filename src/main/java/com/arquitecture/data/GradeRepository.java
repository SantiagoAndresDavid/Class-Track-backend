package com.arquitecture.data;


import com.arquitecture.entity.Grade;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface GradeRepository extends CrudRepository<Grade, Long> {
    List<Grade> findByIdIn(List<Long> ids);
}
