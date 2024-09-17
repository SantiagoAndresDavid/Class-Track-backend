package com.arquitecture.controller;

import com.arquitecture.entity.Role;
import com.arquitecture.service.RoleServices;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;

@Controller("/roles")
@Tag(name = "roles")
public class RoleController {
    @Inject
    RoleServices roleServices;

    @Get(uri="/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Role> getAllRoles() {return roleServices.getAllRoles();}
}
