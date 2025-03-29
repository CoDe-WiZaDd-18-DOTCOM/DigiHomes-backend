package com.example.DigiHomes.controllers;

import com.example.DigiHomes.entities.Favorites;
import com.example.DigiHomes.entities.User;
import com.example.DigiHomes.service.FavoritesService;
import com.example.DigiHomes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoritesController {
    @Autowired
    private FavoritesService favoritesService;

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Favorites>> getAll(@PathVariable String authId){
        try {
            User user = userService.GetUserbyAuth(authId);
            if(user==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            List<Favorites> favorites = favoritesService.getFavorites(user);
            return new ResponseEntity<>(favorites,HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<Favorites> saveProp(@PathVariable String authId,@RequestBody Long propertyId){
        try {
            User user = userService.GetUserbyAuth(authId);
            if(favoritesService.checkByuserandproperty(user,propertyId)) return new ResponseEntity<>(HttpStatus.MULTIPLE_CHOICES);
            Favorites favorites = new Favorites();
            favorites.setUser(user);
            favorites.setPropertyId(propertyId);
            favoritesService.saveFavorites(favorites);
            return new ResponseEntity<>(favorites,HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProp(@PathVariable Long id){
        try {
            if(!favoritesService.checkById(id)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            boolean ck = favoritesService.deleteFavorites(id);
            return new ResponseEntity<>(ck,HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
