package com.example.DigiHomes.repositories;

import com.example.DigiHomes.entities.Facilities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacilitiesRepository extends JpaRepository<Facilities,Long> {
    boolean existsByBedroomsAndBathroomsAndParkings(int bedrooms, int bathrooms, int parkings);
    Optional<Facilities> findByBedroomsAndBathroomsAndParkings(int bedrooms, int bathrooms, int parkings);
}
