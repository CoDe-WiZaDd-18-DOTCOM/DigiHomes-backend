package com.example.DigiHomes.controllers;

import com.example.DigiHomes.entities.User;
import com.example.DigiHomes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/public/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id){
        User user = userService.GetUserbyId(id);
        if(user==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<User> createUser(@RequestBody Map<String, String> payload){
        User dummy = new User();
        dummy.setEmail(payload.get("email"));
        dummy.setAuthid(payload.get("AuthOid"));
        dummy.setName(payload.get("name"));
        User us = userService.SaveUser(dummy);
        if(us==null) return new ResponseEntity<>(HttpStatus.MULTIPLE_CHOICES);
        return new ResponseEntity<>(us,HttpStatus.CREATED);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable("id") Long id,@RequestBody User user){
//        User us = userService.UpdateUser(id,user);
//        if(us==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(us,HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id){
//        Boolean checkByuserandproperty = userService.DeleteUser(id);
//        if(checkByuserandproperty) return new ResponseEntity<>(true,HttpStatus.OK);
//        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
//    }


    @GetMapping("/profile")
    public String getUserProfile(Principal principal) {
        return "Hello, " + principal.getName();
    }
}
