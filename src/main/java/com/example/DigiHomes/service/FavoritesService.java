package com.example.DigiHomes.service;

import com.example.DigiHomes.entities.Favorites;
import com.example.DigiHomes.entities.User;
import com.example.DigiHomes.repositories.FavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritesService {
    @Autowired
    private FavoritesRepository favoritesRepository;

    public void saveFavorites(Favorites favorites){
        favoritesRepository.save(favorites);
    }

    public List<Favorites> getFavorites(User user){
        return favoritesRepository.findAllByUser(user);
    }

    public Favorites getFavoritesById(Long id){
        return favoritesRepository.findById(id).orElse(null);
    }

    public boolean checkByuserandproperty(User user, Long favoritesId){
        return favoritesRepository.existsByUserAndPropertyId(user,favoritesId);
    }

    public boolean checkById(Long id){
        return favoritesRepository.existsById(id);
    }

    public boolean deleteFavorites(Long id){
        Favorites favorites = favoritesRepository.findById(id).orElse(null);
        if(favorites==null) return false;
        favoritesRepository.delete(favorites);
        return true;
    }
}
