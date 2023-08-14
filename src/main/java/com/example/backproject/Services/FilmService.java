package com.example.backproject.Services;


import com.example.backproject.Domain.Film;
import com.example.backproject.Domain.Reservation_film;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface FilmService {

    public ResponseEntity<Reservation_film> reserver (String nom, Date horaire, String email);
    public Film getFilmByName(String name);
    public List<Film> getFilmByGenre(String genre);
    public List<Film> getFilmByRealisateur(String realisateur);

    String getFeedbacks(String nom_film);

    String consulterHora(String nom_film);
}
