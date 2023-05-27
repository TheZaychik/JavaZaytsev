package com.example.backend.repositories;

import com.example.backend.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepo extends JpaRepository<Film, Integer> {
}
