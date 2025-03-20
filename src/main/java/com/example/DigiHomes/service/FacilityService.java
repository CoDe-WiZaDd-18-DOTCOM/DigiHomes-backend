package com.example.DigiHomes.service;

import com.example.DigiHomes.repositories.FacilitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacilityService {
    @Autowired
    private FacilitiesRepository facilitiesRepository;

    public boolean check(int bedrooms,int bathrooms,int parkings){
        return facilitiesRepository.existsByBedroomsAndBathroomsAndParkings(bedrooms, bathrooms, parkings);
    }
}
