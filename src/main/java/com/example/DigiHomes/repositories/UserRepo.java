package com.example.DigiHomes.repositories;

import com.example.DigiHomes.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Boolean existsByauthid(String authid);

    Optional<User> findByAuthid(String id);
}
