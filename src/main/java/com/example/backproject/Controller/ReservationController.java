package com.example.backproject.Controller;


import com.example.backproject.Services.ReservationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api")
@SecurityRequirement(name = "Bearer Authentication")

public class ReservationController {

    @Autowired

    private ReservationService reservationService;

   // appel à la methode payer
    @PostMapping("payer")

    public void payer_online(String nom_film, String orderId,String customerName,String cardNumber,String expiryMonth,String expiryYear,String cvv){
        this.reservationService.payer(nom_film,orderId,customerName,cardNumber,expiryMonth,expiryYear,cvv);

    }


}
