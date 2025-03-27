package com.example.DigiHomes.service;

import com.example.DigiHomes.ResponseDto.PropertyDto;

import com.example.DigiHomes.entities.Properties;
import org.springframework.stereotype.Service;

@Service
public class PropertyToDto {
    public PropertyDto convert(Properties property){
        PropertyDto propertyDto = new PropertyDto();
        propertyDto.setAddress(property.getAddress());
        propertyDto.setCity(property.getLocation().getCity());
        propertyDto.setState(property.getLocation().getState());
        propertyDto.setCountry(property.getLocation().getCountry());
        propertyDto.setAddress(property.getAddress());
        propertyDto.setTitle(property.getTitle());
        propertyDto.setDescription(property.getDescription());
        propertyDto.setImage(property.getImgUrl());
        propertyDto.setId(property.getId());
        propertyDto.setPrice(property.getPrice());
        propertyDto.setUserEmail(property.getEmail());

        return propertyDto;
    }
}
