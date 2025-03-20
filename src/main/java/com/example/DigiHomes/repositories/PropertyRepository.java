package com.example.DigiHomes.repositories;

import com.example.DigiHomes.entities.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Properties,Long> {
}
