package com.example.DigiHomes.service;

import com.example.DigiHomes.entities.Properties;
import com.example.DigiHomes.repositories.FacilitiesRepository;
import com.example.DigiHomes.repositories.LocationsRepository;
import com.example.DigiHomes.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    public Properties getByid(Long id){
        return propertyRepository.findById(id).orElse(null);
    }

    public List<Properties> getAll(){
        return propertyRepository.findAll();
    }

    public Properties saveProperty(Properties properties){
        propertyRepository.save(properties);
        return properties;
    }

    public Properties updateProperty(Properties properties,Long id){
        Properties dbProperty = getByid(id);
        if(dbProperty==null) return null;
        dbProperty.setAddress(properties.getAddress());
        dbProperty.setDescription(properties.getDescription());
        dbProperty.setFacility(properties.getFacility());
        dbProperty.setEmail(properties.getEmail());
        dbProperty.setImgUrl(properties.getImgUrl());
        dbProperty.setLocation(properties.getLocation());
        dbProperty.setPrice(properties.getPrice());
        dbProperty.setTitle(properties.getTitle());
        propertyRepository.save(dbProperty);
        return dbProperty;
    }

    public boolean deleteProperty(Long id){
        try {
            propertyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
