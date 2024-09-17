package com.arquitecture.data;

import com.arquitecture.entity.Role;
import com.arquitecture.entity.User;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface UserRepository extends CrudRepository<User,Long> {
    User findByEmail(String email);
    List<Role> findDistinctRolesById(Long id);
}
