package com.example.DigiHomes.service;

import com.example.DigiHomes.repositories.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Autowired
    private LocationsRepository locationsRepository;

    public boolean check(String city,String state,String country){
        return locationsRepository.existsByCityAndStateAndCountry(city, state, country);
    }
}
