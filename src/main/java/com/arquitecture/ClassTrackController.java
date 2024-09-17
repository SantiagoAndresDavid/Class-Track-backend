package com.arquitecture;

import io.micronaut.http.annotation.*;

@Controller("/class-track")
public class ClassTrackController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}