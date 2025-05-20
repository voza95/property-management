package com.mycompany.property_management.service.impl;

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

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setTitle(propertyDTO.getTitle());
        propertyEntity.setDescription(propertyDTO.getDescription());
        propertyEntity.setAddress(propertyDTO.getAddress());
        propertyEntity.setOwnerEmail(propertyDTO.getOwnerEmail());
        propertyEntity.setOwner(propertyDTO.getOwner());
        propertyEntity.setPrice(propertyDTO.getPrice());

        repository.save(propertyEntity);
        return null;
    }

}

/// @Service, @Controller, @Configuration, @Component, @Repository
/// all of this annotation will make the class object a singleton instance
///
/// Opposite of singleton is prototype
///  Objects like DTO, model or entity should be prototype
