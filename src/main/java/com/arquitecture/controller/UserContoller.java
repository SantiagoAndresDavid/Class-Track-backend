package com.arquitecture.controller;

import com.arquitecture.entity.User;
import com.arquitecture.service.UserServices;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;

@Controller("/Users")
@Tag(name = "Users")
public class UserContoller {
    @Inject
    UserServices userServices;

    @Post(uri = "/save")
    @Produces("application/json")
    public MutableHttpResponse<String> saveUser(@Body User user) {
        return HttpResponse.created(userServices.saveUserWithRoles(user));
    }


}
