package com.example.DigiHomes.controllers;

import com.example.DigiHomes.ResponseDto.PropertyDto;
import com.example.DigiHomes.entities.Locations;
import com.example.DigiHomes.entities.Properties;
import com.example.DigiHomes.service.PropertyService;
import com.example.DigiHomes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Properties>> getProperties(){
        List<Properties> properties = propertyService.getAll();
        if(properties.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(properties,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Properties> getPropertybyid(@PathVariable Long id){
        Properties properties = propertyService.getByid(id);
        if (properties==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(properties,HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<?> addProperty(@RequestBody PropertyDto propertyDto){
//        Locations locations = new Locations();
//        locations.setCity();
//    }
}
