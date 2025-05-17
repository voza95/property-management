package com.mycompany.property_management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello world";
    }
}
