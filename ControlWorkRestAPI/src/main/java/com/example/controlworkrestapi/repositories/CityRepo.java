package com.example.controlworkrestapi.repositories;

import com.example.controlworkrestapi.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City, Integer> {
}
