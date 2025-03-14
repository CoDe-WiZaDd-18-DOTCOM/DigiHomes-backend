package com.example.DigiHomes.repositories;

import com.example.DigiHomes.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Boolean existsByusername(String username);
}
