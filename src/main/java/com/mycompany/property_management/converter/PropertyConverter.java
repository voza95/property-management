package com.mycompany.property_management.converter;

import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.entity.PropertyEntity;
import org.springframework.stereotype.Component;

// To make class singleton, and we can inject it/autowire it in our service layer
@Component
public class PropertyConverter {

    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO) {

        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setTitle(propertyDTO.getTitle());
        propertyEntity.setDescription(propertyDTO.getDescription());
        propertyEntity.setAddress(propertyDTO.getAddress());
        propertyEntity.setOwnerEmail(propertyDTO.getOwnerEmail());
        propertyEntity.setOwner(propertyDTO.getOwner());
        propertyEntity.setPrice(propertyDTO.getPrice());

        return propertyEntity;
    }
}

