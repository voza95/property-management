package com.mycompany.property_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDTO {

    private String title;
    private String description;
    private String owner;
    private String ownerEmail;
    private Double price;
    private String address;


}
