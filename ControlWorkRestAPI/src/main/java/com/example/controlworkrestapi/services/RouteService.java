package com.example.controlworkrestapi.services;

import com.example.controlworkrestapi.models.Route;
import com.example.controlworkrestapi.repositories.CityRepo;
import com.example.controlworkrestapi.repositories.RouteRepo;
import com.example.controlworkrestapi.schemas.RouteSchema;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RouteService {
    @Autowired
    RouteRepo routeRepo;
    @Autowired
    CityRepo cityRepo;

    public List<Route> getAllRoutes() {
        return routeRepo.findAll();
    }

    public Route getRouteById(Integer id) {
        return routeRepo.findById(id).get();
    }

    public void create(RouteSchema routeSchema) {
        Route route = new Route();
        route.setCityFrom(cityRepo.findById(routeSchema.cityFrom).get());
        route.setCityTo(cityRepo.findById(routeSchema.cityTo).get());
        routeRepo.save(route);
    }

    public void update(RouteSchema routeSchema, Integer id) {
        Route routeToUpdate = routeRepo.findById(id).get();
        if (routeSchema.cityTo != null) {
            routeToUpdate.setCityTo(cityRepo.findById(routeSchema.cityTo).get());
        }
        if (routeSchema.cityFrom != null) {
            routeToUpdate.setCityFrom(cityRepo.findById(routeSchema.cityFrom).get());
        }
        routeRepo.save(routeToUpdate);
    }

    public void delete(Integer id) {
        routeRepo.deleteById(id);
    }

}
