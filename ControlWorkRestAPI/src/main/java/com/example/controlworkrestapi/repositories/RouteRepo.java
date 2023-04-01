package com.example.controlworkrestapi.repositories;

import com.example.controlworkrestapi.models.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepo extends JpaRepository<Route, Integer> {
}
