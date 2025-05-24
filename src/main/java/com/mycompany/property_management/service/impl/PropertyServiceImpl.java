package com.mycompany.property_management.service.impl;

import com.mycompany.property_management.converter.PropertyConverter;
import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.entity.PropertyEntity;
import com.mycompany.property_management.repository.PropertyRepository;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> propertyEntityList = (List<PropertyEntity>) repository.findAll();
        List<PropertyDTO> dtoList = new ArrayList<>();
        for (PropertyEntity entity: propertyEntityList) {
            PropertyDTO dto = converter.convertEntityToDTO(entity);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> property = repository.findById(propertyId);
        if (property.isPresent()) {
            PropertyEntity propertyEntity = property.get();
            propertyEntity.setTitle(propertyDTO.getTitle());
            propertyEntity.setDescription(propertyDTO.getDescription());
            propertyEntity.setAddress(propertyDTO.getAddress());
            propertyEntity.setOwnerEmail(propertyDTO.getOwnerEmail());
            propertyEntity.setOwner(propertyDTO.getOwner());
            propertyEntity.setPrice(propertyDTO.getPrice());

            repository.save(propertyEntity);

            return converter.convertEntityToDTO(propertyEntity);
        }
        return null;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> property = repository.findById(propertyId);
        if (property.isPresent()) {
            PropertyEntity propertyEntity = property.get();
            propertyEntity.setDescription(propertyDTO.getDescription());
            repository.save(propertyEntity);

            return converter.convertEntityToDTO(propertyEntity);
        }
        return null;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> property = repository.findById(propertyId);
        if (property.isPresent()) {
            PropertyEntity propertyEntity = property.get();
            propertyEntity.setPrice(propertyDTO.getPrice());
            repository.save(propertyEntity);

            return converter.convertEntityToDTO(propertyEntity);
        }
        return null;
    }

    @Override
    public void deleteProperty(Long id) {
        repository.deleteById(id);
    }

}

/// @Service, @Controller, @Configuration, @Component, @Repository
/// all of this annotation will make the class object a singleton instance
///
/// Opposite of singleton is prototype
///  Objects like DTO, model or entity should be prototype
