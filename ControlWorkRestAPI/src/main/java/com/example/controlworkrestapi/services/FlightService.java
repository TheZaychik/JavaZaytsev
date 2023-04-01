package com.example.controlworkrestapi.services;

import com.example.controlworkrestapi.models.Flight;
import com.example.controlworkrestapi.repositories.FlightRepo;
import com.example.controlworkrestapi.repositories.RouteRepo;
import com.example.controlworkrestapi.schemas.FlightSchema;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FlightService {
    @Autowired
    FlightRepo flightRepo;

    @Autowired
    RouteRepo routeRepo;

    public List<Flight> getAllFlights() {
        return flightRepo.findAll();
    }

    public Flight getFlightById(Integer id) {
        return flightRepo.findById(id).get();
    }

    public void create(FlightSchema flightSchema) {
        Flight flight = new Flight();
        flight.setRoute(routeRepo.findById(flightSchema.routeId).get());
        flight.setAviaName(flightSchema.aviaName);
        flight.setDatetime(flightSchema.datetime);
        flight.setDuration(flightSchema.duration);
        flightRepo.save(flight);
    }

    public void update(FlightSchema flightSchema, Integer id) {
        Flight flightToUpdate = flightRepo.findById(id).get();
        if (flightSchema.routeId != null) {
            flightToUpdate.setRoute(routeRepo.findById(flightSchema.routeId).get());
        }
        if (flightSchema.aviaName != null) {
            flightToUpdate.setAviaName(flightSchema.aviaName);
        }
        if (flightSchema.datetime != null) {
            flightToUpdate.setDatetime(flightSchema.datetime);
        }
        if (flightSchema.duration != null) {
            flightToUpdate.setDuration(flightSchema.duration);
        }
        flightRepo.save(flightToUpdate);
    }

    public void delete(Integer id) {
        flightRepo.deleteById(id);
    }

}
