package com.arquitecture.controller.Role;

import com.arquitecture.entity.Role;
import com.arquitecture.service.RoleServices;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.*;
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

    @Post(uri = "/save")
    @Produces(MediaType.APPLICATION_JSON)
    public MutableHttpResponse<String> saveRole(@Body Role role) {
        return HttpResponse.created(roleServices.saveRole(role));
    }
}
