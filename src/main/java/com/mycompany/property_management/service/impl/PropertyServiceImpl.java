package com.mycompany.property_management.service.impl;

import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        return null;
    }

}

/// @Service, @Controller, @Configuration, @Component, @Repository
/// all of this annotation will make the class object a singleton instance
///
/// Opposite of singleton is prototype
///  Objects like DTO, model or entity should be prototype
