package com.arquitecture.controller.Notification;


import com.arquitecture.entity.Notification;
import com.arquitecture.service.NotificationService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;

@Controller("/Notification")
@Tag(name = "Notification")
public class NotificationController {
    @Inject
    NotificationService notificationService;

    @Post("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public MutableHttpResponse<String> createNotification(@Body Notification notification) {
        String response = notificationService.createNotification(notification);
        if(response.equals("Notification created")){
            return HttpResponse.created(response);
        }else {
            return HttpResponse.badRequest(response);
        }
    }

}
