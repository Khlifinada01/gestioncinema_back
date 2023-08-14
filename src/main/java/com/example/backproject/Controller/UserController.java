package com.example.backproject.Controller;


import com.example.backproject.Domain.AuthenticationBean;
import com.example.backproject.Domain.Reservation_film;
import com.example.backproject.ServiceImplimentation.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired

    private PersonServiceImpl personService;

    // retouner toutes les reservations relatives à cette personne



    @GetMapping(path="/basic_auth")

    public AuthenticationBean login(){
        return new AuthenticationBean("nada","pwd");
    }
    @GetMapping("get_All_Reservation")

    public List<Reservation_film> getReservation(@RequestParam String email){
        return this.personService.getAllReservation(email);
    }
  // appel à l'annulation de reservation
    @DeleteMapping("annuler_Reservation")
    public  void annuler_Reservation(@RequestParam String email , String ref_reservation){
        this.personService.CancelReservation(email,ref_reservation);
    }

    // mis à jour de l email
    @PostMapping("updateProfile_Email")

    public void update_Profile_Email(@RequestParam String old_email ,@RequestParam String new_email  ){
        this.personService.updateAdress(old_email,new_email);
    }
    // MAJ de mdp
    @PostMapping("updateProfile_Mdp")

    public void update_Profile_Mdp(@RequestParam String mdp_new , @RequestParam String email ){
        this.personService.updateMdp(mdp_new,email);
    }
    // màj de nom
    @PostMapping("updateProfile_Nom")

    public void update_Profile_Nom(@RequestParam String nom , @RequestParam String email ){
        this.personService.updateName(nom,email);
    }




}
