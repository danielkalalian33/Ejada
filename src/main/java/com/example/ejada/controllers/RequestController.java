package com.example.ejada.controllers;

import com.example.ejada.models.Request;
import com.example.ejada.models.Statistics;
import com.example.ejada.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RequestController {
    @Autowired
    RequestService requestService;

    @PostMapping("/request")
    String handleDifferentRequests(@RequestBody Request request) {
        return requestService.handleDifferentRequests(request);
    }

    @GetMapping("/Admin")
    Statistics applicationStatistics() {
        return requestService.applicationStatistics();
    }
}
