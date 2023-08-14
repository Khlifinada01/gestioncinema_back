package com.example.backproject.ServiceImplimentation;


import com.example.backproject.Domain.Person;
import com.example.backproject.Domain.Reservation_film;
import com.example.backproject.Repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl {

    private PersonRepo personRepo;
    public Person getUserByEmail(String email) {


        return this.personRepo.getUserByEmail(email);
    }

    public List<Reservation_film> getAllReservation(String email) {
        Person u=  this.personRepo.getUserByEmail(email);

        List<Reservation_film> reservationFilmList = new ArrayList<>();
        reservationFilmList.add(u.getReservationFilm());
        return reservationFilmList;
    }

    public void CancelReservation(String email, String ref_reservation) {

        Person user = this.personRepo.getUserByEmail(email);
        user.getReservationFilm().getReservation_ref();

        String  res =  user.getReservationFilm().getReservation_ref();
        if(ref_reservation==res) {

            this.personRepo.deleteReservation(res);
        }

        System.out.println("la référence passée ne correspond à aucun film ! ");


    }

    public void updateAdress(String old_email, String new_email) {

        Person pers = this.personRepo.getUserByEmail(old_email);
        pers.setEmail(new_email);
        this.personRepo.save(pers);
    }

    public void updateMdp(String mdp_new, String email) {
        Person per = this.personRepo.getUserByEmail(email);

        per.setMdp(mdp_new);
        personRepo.save(per);


    }

    public void updateName(String nom, String email) {

        Person p = this.personRepo.getUserByEmail(email);
        p.setName(nom);
        this.personRepo.save(p);
    }
}
