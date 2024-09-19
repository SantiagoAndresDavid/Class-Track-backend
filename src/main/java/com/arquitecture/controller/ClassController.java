package com.arquitecture.controller;

import com.arquitecture.entity.Class;
import com.arquitecture.entity.User;
import com.arquitecture.service.ClassService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;

@Controller("/class")
@Tag(name = "class")
public class ClassController {
    @Inject
    ClassService classService;

    @Post("/save")
    @Produces(MediaType.APPLICATION_JSON)
    public MutableHttpResponse<String> saveClass(@Body Class classItem) {
        String response = classService.saveClass(classItem);
        if(response.equals("User saved with roles")){
            return HttpResponse.created(response);
        }else {
            return HttpResponse.badRequest(response);
        }
    }
}
