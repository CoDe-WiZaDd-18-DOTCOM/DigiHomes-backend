package com.example.DigiHomes.repositories;


import com.example.DigiHomes.entities.Favorites;
import com.example.DigiHomes.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites,Long> {
    List<Favorites> findAllByUser(User user);
    boolean existsByUserAndPropertyId(User user,Long propertyId);
    Optional<Favorites> findByUserAndPropertyId(User user, Long propertyId);
}
