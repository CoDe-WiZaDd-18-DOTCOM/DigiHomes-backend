package com.example.DigiHomes.repositories;

import com.example.DigiHomes.entities.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationsRepository extends JpaRepository<Locations,Long> {
    boolean existsByCityAndStateAndCountry(String city,String state,String country);
    Optional<Locations> findByCityAndStateAndCountry(String city,String state,String country);
}
