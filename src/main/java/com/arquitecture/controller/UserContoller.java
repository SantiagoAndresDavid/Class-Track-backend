package com.arquitecture.controller;

import com.arquitecture.entity.User;
import com.arquitecture.service.UserServices;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
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
    @Produces(MediaType.APPLICATION_JSON)
    public MutableHttpResponse<String> saveUser(@Body User user) {
        String response = userServices.saveUser(user);
        if(response.equals("User saved with roles")){
            return HttpResponse.created(response);
        }else {
            return HttpResponse.badRequest(response);
        }
    }

    @Get(uri = "/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public MutableHttpResponse<User> getUserByEmail(@PathVariable String email) {
        return HttpResponse.ok(userServices.getUserById(email));
    }

   @Get(uri = "/sign-in")
   @Produces(MediaType.APPLICATION_JSON)
    public MutableHttpResponse<Boolean> singIn(String email,String password){
        return HttpResponse.ok(userServices.singIn(email,password));
   }
}
