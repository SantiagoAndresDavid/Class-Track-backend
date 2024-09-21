package com.arquitecture.controller.user;

import com.arquitecture.entity.Grade;
import com.arquitecture.entity.User;
import com.arquitecture.service.UserServices;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@Controller("/users")
@Tag(name = "Users")
public class UserContoller {
    @Inject
    UserServices userServices;

    @Post(uri = "/save")
    @Produces(MediaType.APPLICATION_JSON)
    public MutableHttpResponse<String> saveUser(@Body UserSaveRequest user) {
        String response = userServices.saveUser(user.toUser());
        if(response.equals("User saved with roles")){
            return HttpResponse.created(response);
        }else {
            return HttpResponse.badRequest(response);
        }
    }

    @Get(uri = "/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MutableHttpResponse<User> getUserByEmail(@PathVariable Long id) {
        User user = userServices.getUserById(id);
        return HttpResponse.ok(user);
    }

   @Get(uri = "/sign-in")
   @Produces(MediaType.APPLICATION_JSON)
    public MutableHttpResponse<Boolean> singIn(String email,String password){
        return HttpResponse.ok(userServices.singIn(email,password));
   }

    @Put(uri = "/add-grade")
    @Produces(MediaType.APPLICATION_JSON)
    public MutableHttpResponse<String> updateUser(@Body AddGradeToUserRequest addGradeToUserRequest) {
        /*List<Grade> grades = addGradeToUserRequest.grades().stream()
                .map(grade -> new Grade(grade.id()))
                .collect(Collectors.toList());*/
        String response = userServices.addGradeToUser(addGradeToUserRequest.id(), addGradeToUserRequest.grades());
        if (response.equals("Class added to user")) {
            return HttpResponse.created(response);
        } else {
            return HttpResponse.badRequest(response);
        }
    }

    @Get(uri = "/get-all")
    @Produces(MediaType.APPLICATION_JSON)
    public MutableHttpResponse<List<User>> singIn(){
        return HttpResponse.ok(userServices.getAllUsers());
    }

}
