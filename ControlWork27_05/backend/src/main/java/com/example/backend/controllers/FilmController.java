package com.example.backend.controllers;

import com.example.backend.models.Film;
import com.example.backend.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/film")
public class FilmController {
    @Autowired
    FilmService filmService;

    @GetMapping("")
    public List<Film> getAllRooms() {
        return filmService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getById(@PathVariable Integer id) {
        try{
            Film film = filmService.getById(id);
            return new ResponseEntity<>(film, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void create(@RequestBody Film film){
        filmService.create(film);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Film film){
       try {
           filmService.update(film, id);
           return new ResponseEntity<>(HttpStatus.OK);
       }
       catch (NoSuchElementException e){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Integer id){
        filmService.delete(id);
    }

}
