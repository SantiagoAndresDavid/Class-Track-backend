package com.arquitecture.data;

import com.arquitecture.entity.Role;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;


@JdbcRepository(dialect = Dialect.POSTGRES)
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}


