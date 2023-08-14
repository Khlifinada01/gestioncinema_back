package com.example.backproject.ServiceImplimentation;


import com.example.backproject.Domain.Film;
import com.example.backproject.Domain.Person;
import com.example.backproject.Domain.Reservation_film;
import com.example.backproject.Repository.FilmReposiroty;
import com.example.backproject.Repository.PersonRepo;
import com.example.backproject.Repository.ReservationRepository;
import com.example.backproject.Services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {


    @Autowired

    private PersonServiceImpl personService;

    private PersonRepo personRepo;


    private ReservationRepository reservationRepository;



    private FilmReposiroty filmReposiroty;

    @Override
    public ResponseEntity<Reservation_film> reserver(String nom, Date horaire, String email) {
        if(nom!=null && horaire!=null){

            try{
                System.out.println("entre pour la reservation");
                Person user = personService.getUserByEmail(email);
                Film filmChoosen = getFilmByName(nom);

                Reservation_film reservationFilm = new Reservation_film();
                reservationFilm.setReservation_ref("reservation :"+nom+"ayant email "+email);
                reservationFilm.setFilm(filmChoosen);
                this.reservationRepository.save(reservationFilm);
                user.setReservationFilm(reservationFilm);
                this.personRepo.save(user);
                ResponseEntity r = new ResponseEntity<>(reservationFilm,HttpStatus.OK);
                return r;

            }catch (Exception e){
                System.out.println("oooooooups !! ");
            }
        }
        return null;
    }

    // trouver film selon le nom
    @Override
    public Film getFilmByName(String name) {
        return this.filmReposiroty.getFilmByNom_film(name);
    }

    // trouver film selon le genre

    @Override
    public List<Film> getFilmByGenre(String genre) {
        return  this.filmReposiroty.findFilmByGenre(genre);
    }
    // trouver film selon le realisateur

    public List<Film> getFilmByRealisateur(String realisateur) {
        return  this.filmReposiroty.findFilmByRealisateur(realisateur);
    }


    // retourner les feedbacks du film choisi
    @Override
    public String getFeedbacks(String nom_film) {
        Film film_searched = this.filmReposiroty.getFilmByNom_film(nom_film);
        String film_feedbakcs = film_searched.getFeed_backs();
        return film_feedbakcs;
    }

    @Override
    public String consulterHora(String nom_film) {
        Film film_serched = this.filmReposiroty.getFilmByNom_film(nom_film);
        String hor = film_serched.getHoraires_dispo();
        return hor;
    }


}
