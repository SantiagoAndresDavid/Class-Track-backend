package com.arquitecture.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.HashMap;
import java.util.Map;

@Controller("/healthCheck")
@Tag(name = "healthCheck")
public class HealthCheck {

    @Get(uri="/get", produces=MediaType.APPLICATION_JSON)
    public HttpResponse<Map<String, String>> healthCheck() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return HttpResponse.ok(response);
    }
}
