package com.example.backproject.Domain;


import javax.persistence.*;


@Entity
@Table(name = "Reservation_film")
public class Reservation_film {


    public void setFilm(Film film) {
        this.film = film;
    }

    public void setReservation_ref(String reservation_ref) {
        this.reservation_ref= reservation_ref;
    }

    public String getReservation_ref() {
        return reservation_ref;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String reservation_ref;

    public Film getFilm() {
        return film;
    }

    // plusieurs reservation effectuees pour un seeul film
    @Access(AccessType.PROPERTY)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="filmId")

    private Film film;



}
