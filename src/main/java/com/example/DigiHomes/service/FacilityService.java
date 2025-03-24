package com.example.DigiHomes.service;

import com.example.DigiHomes.entities.Facilities;
import com.example.DigiHomes.repositories.FacilitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacilityService {
    @Autowired
    private FacilitiesRepository facilitiesRepository;

    public boolean check(int bedrooms,int bathrooms,int parkings){
        boolean exists = facilitiesRepository.existsByBedroomsAndBathroomsAndParkings(bedrooms, bathrooms, parkings);
        System.out.println("Checking facility existence: " + bedrooms + ", " + bathrooms + ", " + parkings + " -> Exists? " + exists);
        return exists;
    }

    public Facilities get(int bedrooms, int bathrooms, int parkings){
        return facilitiesRepository.findByBedroomsAndBathroomsAndParkings(bedrooms, bathrooms, parkings).orElse(null);
    }

    public void saveFacility(Facilities facilities){
        facilitiesRepository.save(facilities);
    }
}
