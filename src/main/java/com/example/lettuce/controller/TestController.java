package com.example.lettuce.controller;

import com.example.lettuce.model.TestRequest;
import com.example.lettuce.service.TestService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    private TestService service;

    public TestController(TestService service) {
        this.service = service;
    }

    @GetMapping("/api/value/{id}")
    public String getRedis(@PathVariable Integer id) {
        return service.getRedisKey(id);
    }

    @PostMapping("/api/value")
    public void setRedis(@RequestBody TestRequest request) {
        service.setRedisKey(request);
    }
}
