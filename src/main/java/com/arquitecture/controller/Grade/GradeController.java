package com.arquitecture.controller.Grade;


import com.arquitecture.entity.Grade;
import com.arquitecture.service.GradeService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;

@Controller("/grade")
@Tag(name = "Grade")
public class GradeController {
    @Inject
    GradeService classService;

    @Post("/save")
    @Produces(MediaType.APPLICATION_JSON)
    public MutableHttpResponse<String> saveClass(@Body Grade grade) {
        String response = classService.saveClass(grade);
        if(response.equals("User saved with roles")){
            return HttpResponse.created(response);
        }else {
            return HttpResponse.badRequest(response);
        }
    }
}
