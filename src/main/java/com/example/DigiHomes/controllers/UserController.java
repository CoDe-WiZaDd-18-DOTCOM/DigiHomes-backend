package com.example.DigiHomes.controllers;

import com.example.DigiHomes.entities.User;
import com.example.DigiHomes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id){
        User user = userService.GetUserbyId(id);
        if(user==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User dummy = new User();
        dummy.setUsername(user.getUsername());
        dummy.setPassword(user.getPassword());
        User us = userService.SaveUser(dummy);
        if(us==null) return new ResponseEntity<>(HttpStatus.MULTIPLE_CHOICES);
        return new ResponseEntity<>(us,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id,@RequestBody User user){
        User us = userService.UpdateUser(id,user);
        if(us==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(us,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id){
        Boolean check = userService.DeleteUser(id);
        if(check) return new ResponseEntity<>(true,HttpStatus.OK);
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
