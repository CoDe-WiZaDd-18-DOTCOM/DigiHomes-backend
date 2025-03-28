package com.example.DigiHomes.service;

import com.example.DigiHomes.entities.User;
import com.example.DigiHomes.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User SaveUser(User user){
        if(userRepo.existsByauthid(user.getAuthid())) return null;
        return userRepo.save(user);
    }

    public User GetUserbyId(Long id){
        return userRepo.findById(id).orElse(null);
    }

    public User GetUserbyAuth(String id){
        return userRepo.findByAuthid(id).orElse(null);
    }

//    public User UpdateUser(Long id, User user){
//        User dbuser = GetUserbyId(id);
//        if(dbuser==null) return null;
//        if(!dbuser.getEmail().equals(user.getEmail())) {
//            dbuser.setEmail(user.getEmail());
//            dbuser.setPassword(user.getPassword());
//            return SaveUser(dbuser);
//        }
//        dbuser.setPassword(user.getPassword());
//        return userRepo.save(dbuser);
//    }
//
//    public Boolean DeleteUser(Long id){
//        if(!userRepo.existsById(id)) return false;
//        userRepo.deleteById(id);
//        return true;
//    }
}
