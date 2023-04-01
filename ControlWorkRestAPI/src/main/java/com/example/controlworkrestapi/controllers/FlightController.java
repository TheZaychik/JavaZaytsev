package com.example.controlworkrestapi.controllers;

import com.example.controlworkrestapi.models.Flight;
import com.example.controlworkrestapi.schemas.FlightSchema;
import com.example.controlworkrestapi.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    FlightService flightService;

    @GetMapping("")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Integer id) {
        try {
            Flight flight = flightService.getFlightById(id);
            return new ResponseEntity<>(flight, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void addFlight(@RequestBody FlightSchema flightSchema) {
        flightService.create(flightSchema);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFlight(@PathVariable Integer id, @RequestBody FlightSchema flightSchema) {
        try {
            flightService.update(flightSchema, id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Integer id) {
        flightService.delete(id);
    }

}
