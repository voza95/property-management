package com.mycompany.property_management.service.impl;

import com.mycompany.property_management.converter.PropertyConverter;
import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.entity.PropertyEntity;
import com.mycompany.property_management.repository.PropertyRepository;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository repository;

    @Autowired
    private PropertyConverter converter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = converter.convertDTOtoEntity(propertyDTO);
        propertyEntity = repository.save(propertyEntity);

        propertyDTO = converter.convertEntityToDTO(propertyEntity);
        return propertyDTO;
    }

}

/// @Service, @Controller, @Configuration, @Component, @Repository
/// all of this annotation will make the class object a singleton instance
///
/// Opposite of singleton is prototype
///  Objects like DTO, model or entity should be prototype
