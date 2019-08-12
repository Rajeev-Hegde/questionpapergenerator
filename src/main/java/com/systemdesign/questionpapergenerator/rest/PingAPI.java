package com.systemdesign.questionpapergenerator.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PingAPI {



    @GetMapping
    public String ping() {
        return  "This is a question generator application. To query use /api/v1/question/query";
    }
}
