package com.example.DigiHomes.controllers;

import com.example.DigiHomes.ResponseDto.FacilityDto;
import com.example.DigiHomes.ResponseDto.PropertyDto;
import com.example.DigiHomes.entities.Facilities;
import com.example.DigiHomes.entities.Locations;
import com.example.DigiHomes.entities.Properties;
import com.example.DigiHomes.entities.User;
import com.example.DigiHomes.service.FacilityService;
import com.example.DigiHomes.service.LocationService;
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

    @Autowired
    private LocationService locationService;

    @Autowired
    private FacilityService facilityService;

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

    @PostMapping("/{id}")
    public ResponseEntity<?> addProperty(@RequestBody PropertyDto propertyDto,@PathVariable String id){
        try{
            Locations locations;
            String city= propertyDto.getCity(),state= propertyDto.getState(),country= propertyDto.getCountry();
            if(locationService.check(city,state,country)) {
                locations = locationService.get(city,state,country);
            }
            else {
                locations = new Locations();
                locations.setCity(city);
                locations.setState(state);
                locations.setCountry(country);
                locationService.saveLocation(locations);
            }

            Facilities facilities;
            FacilityDto facilityDto = propertyDto.getFacilities();
            int bedrooms= facilityDto.getBedrooms(),bathrooms= facilityDto.getBathrooms(),parkings= facilityDto.getParkings();
            if(facilityService.check(bedrooms,bathrooms,parkings))
                facilities=facilityService.get(bedrooms,bathrooms,parkings);
            else{
                facilities = new Facilities();
                facilities.setBathrooms(bathrooms);
                facilities.setBedrooms(bedrooms);
                facilities.setParkings(parkings);
                facilityService.saveFacility(facilities);
            }

            Properties properties = new Properties();
            properties.setTitle(propertyDto.getTitle());
            properties.setDescription(propertyDto.getDescription());
            properties.setAddress(propertyDto.getAddress());
            properties.setEmail(propertyDto.getUserEmail());
            properties.setImgUrl(propertyDto.getImage());
            properties.setLocation(locations);
            properties.setFacility(facilities);
            properties.setPrice(propertyDto.getPrice());

            User user = userService.GetUserbyAuth(id);
            if(user==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            properties.setUser(user);
            propertyService.saveProperty(properties);
            userService.SaveUser(user);
            return new ResponseEntity<>(properties,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProperty(@PathVariable Long id){
        boolean check = propertyService.deleteProperty(id);
        if(check) return new ResponseEntity<>(true,HttpStatus.OK);
        return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
    }
}
