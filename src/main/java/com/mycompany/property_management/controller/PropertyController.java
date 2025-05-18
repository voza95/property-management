package com.mycompany.property_management.controller;

import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello world";
    }

    @PostMapping("/save")
    public PropertyDTO saveProperty(@RequestBody PropertyDTO propertyDTO) {
        System.out.println(propertyDTO);
        return propertyService.saveProperty(propertyDTO);
    }
}

/// In spring boot we don't directly save the data to database as a good practice.
/// We have 3 layers controller, service, repository/DAO
/// DAO communicates with database
/// Service is used to connect controller and DAO
/// Controller is use to get the user data