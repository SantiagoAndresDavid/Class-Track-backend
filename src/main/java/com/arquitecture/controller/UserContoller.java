package com.arquitecture.controller;

import com.arquitecture.entity.User;
import com.arquitecture.service.UserServices;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;

@Controller("/users")
@Tag(name = "Users")
public class UserContoller {
    @Inject
    UserServices userServices;

    @Post(uri = "/save")
    @Produces("application/json")
    public MutableHttpResponse<String> saveUser(@Body User user) {
        return HttpResponse.created(userServices.saveUser(user));
    }

    @Get(uri = "/{email}")
    @Produces("application/json")
    public MutableHttpResponse<User> getUserByEmail(@PathVariable String email) {
        return HttpResponse.ok(userServices.getUserById(email));
    }

   @Get(uri = "/sign-in")
   @Produces("application/json")
    public MutableHttpResponse<Boolean> singIn(String email,String password){
        return HttpResponse.ok(userServices.singIn(email,password));
   }
}
