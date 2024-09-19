package com.arquitecture.data;

import com.arquitecture.entity.Attendance;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface AttendanceRepository extends CrudRepository<Attendance, Long> {
}
