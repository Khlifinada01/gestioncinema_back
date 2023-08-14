package com.example.backproject.Domain;



import javax.persistence.*;


@Entity
@Table(name ="Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    private String mdp;

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public void setReservationFilm(Reservation_film reservationFilm) {
        this.reservationFilm = reservationFilm;
    }

    public Reservation_film getReservationFilm() {
        return reservationFilm;
    }

    @OneToOne

    private Reservation_film reservationFilm;


    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
