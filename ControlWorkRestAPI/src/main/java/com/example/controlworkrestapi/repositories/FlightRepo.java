package com.example.controlworkrestapi.repositories;

import com.example.controlworkrestapi.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepo extends JpaRepository<Flight, Integer> {
}
