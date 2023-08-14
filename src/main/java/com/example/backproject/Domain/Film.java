package com.example.backproject.Domain;



import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom_film;

    public String getFeed_backs() {
        return feed_backs;
    }

    private String genre;
    private String realisateur;

    public void setFeed_backs(String feed_backs) {
        this.feed_backs = feed_backs;
    }

    private String feed_backs;

    public String getGenre() {
        return genre;
    }

    public Boolean getStatus_payement() {
        return status_payement;
    }

    public void setStatus_payement(Boolean status_payement) {
        this.status_payement = status_payement;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNom_film() {
        return nom_film;
    }

    public void setNom_film(String nom_film) {
        this.nom_film = nom_film;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public void setHoraires_dispo(String horaires_dispo) {
        this.horaires_dispo = horaires_dispo;
    }

    public String getHoraires_dispo() {
        return horaires_dispo;
    }

    private String horaires_dispo;

    private Boolean status_payement;




    // un film peut etre reservés plusieurs fois
    //@OneToMany(mappedBy = "film")

    @OneToMany(targetEntity=Reservation_film.class,cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    private List<Reservation_film> reservation_films;

    @Transient

    public List<Reservation_film> getReservation_films() {
        return reservation_films;
    }

    public void setReservation_films(List<Reservation_film> reservation_films) {
        this.reservation_films = reservation_films;
    }


    @OneToMany(mappedBy = "person")

    private List<Person> persons;



    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
