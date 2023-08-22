package com.example.backproject.Controller;


import com.example.backproject.Domain.Film;
import com.example.backproject.Domain.Reservation_film;
import com.example.backproject.Services.FilmService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController

@RequestMapping(path = "/api")
@SecurityRequirement(name = "Bearer Authentication")

public class FilmController {

    @Autowired
    private FilmService filmService;


    // appel à la reservation de film choisi
    @PostMapping("/reserver_Film")

    public ResponseEntity<Reservation_film> reserve (@RequestParam String nomFilm, @RequestParam Date horaire, @RequestParam String email ){


        return this.filmService.reserver(nomFilm,horaire,email);
    }

    // recupérer film selon son titre
    @GetMapping("/getFilmByName")

    public Film getFilmByName(@RequestParam String name){


        return this.filmService.getFilmByName(name);
    }
    // récupération film selon genre
    @GetMapping("/getFilmBy_Genre")

    public List<Film> getFilmByGenre(@RequestParam String genre){


        return this.filmService.getFilmByGenre(genre);
    }


   // recupérer film par réalisateur
    @GetMapping("/getFilmBy_Realisateur")

    public List<Film> getFilmByRealisareur(@RequestParam String realisateur){
        return this.filmService.getFilmByRealisateur(realisateur);
    }
 // voir feedbacks de ce film
    @GetMapping("/getFeedbackBy_Film")

    public String getFeedback_Byfilm(@RequestParam String nom_film){

        return this.filmService.getFeedbacks(nom_film);
    }

    // recupérer les horaires relatifs à ce film
    @GetMapping("consulter_horaire")

    public String consulter_horaire(@RequestParam String nom_film){
        return  this.filmService.consulterHora(nom_film);
    }



}
