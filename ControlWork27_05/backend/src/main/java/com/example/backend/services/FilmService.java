package com.example.backend.services;

import com.example.backend.models.Film;
import com.example.backend.repositories.FilmRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FilmService {
    @Autowired
    FilmRepo filmRepo;

    public List<Film> getAll() {
        return filmRepo.findAll();
    }

    public Film getById(Integer id) {
        return filmRepo.findById(id).get();
    }

    public void create(Film film) {
        filmRepo.save(film);
    }

    public void update(Film film, Integer id) {
        Film filmToUpdate = filmRepo.findById(id).get();
        if (film.getName() != null) {
            filmToUpdate.setName(film.getName());
        }
        if (film.getGenre() != null) {
            filmToUpdate.setGenre(film.getGenre());
        }
        if (film.getDuration() != null) {
            filmToUpdate.setDuration(film.getDuration());
        }
        if (film.getYear() != null) {
            filmToUpdate.setYear(film.getYear());
        }

        filmRepo.save(filmToUpdate);

    }

    public void delete(Integer id) {
        filmRepo.deleteById(id);
    }

}
