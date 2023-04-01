package com.example.controlworkrestapi.controllers;

import com.example.controlworkrestapi.models.Route;
import com.example.controlworkrestapi.schemas.RouteSchema;
import com.example.controlworkrestapi.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/routes")
public class RouteController {
    @Autowired
    RouteService routeService;

    @GetMapping("")
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Route> getRouteById(@PathVariable Integer id) {
        try{
            Route route = routeService.getRouteById(id);
            return new ResponseEntity<>(route, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void addRoute(@RequestBody RouteSchema routeSchema){
        routeService.create(routeSchema);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRoute(@PathVariable Integer id, @RequestBody RouteSchema routeSchema){
       try {
           routeService.update(routeSchema, id);
           return new ResponseEntity<>(HttpStatus.OK);
       }
       catch (NoSuchElementException e){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @DeleteMapping("/{id}")
    public void deleteRoute(@PathVariable Integer id){
        routeService.delete(id);
    }

}
