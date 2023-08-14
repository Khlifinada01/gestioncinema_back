package com.example.backproject.Repository;

import com.example.backproject.Domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FilmReposiroty extends JpaRepository<Film,Long> {


    @Query("SELECT f from Film f where  f.nom_film=:nom")
    public Film getFilmByNom_film(String nom);
    @Query("SELECT film FROM Film film  where film.genre=:genre")
    List<Film> findFilmByGenre(String genre);
    @Query("SELECT film FROM Film film where film .realisateur=:realisateur")

    List<Film> findFilmByRealisateur(String realisateur);

}
