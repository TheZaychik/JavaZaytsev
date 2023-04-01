package com.example.controlworkrestapi.controllers;

import com.example.controlworkrestapi.models.City;
import com.example.controlworkrestapi.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping("")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Integer id) {
        try{
            City city = cityService.getCityById(id);
            return new ResponseEntity<>(city, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void addCity(@RequestBody City city){
        cityService.create(city);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCity(@PathVariable Integer id, @RequestBody City city){
       try {
           cityService.update(city, id);
           return new ResponseEntity<>(HttpStatus.OK);
       }
       catch (NoSuchElementException e){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Integer id){
        cityService.delete(id);
    }

}
