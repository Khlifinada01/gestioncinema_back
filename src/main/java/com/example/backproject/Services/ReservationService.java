package com.example.backproject.Services;


import org.springframework.stereotype.Service;


@Service
public interface ReservationService {

    public void payer(String nom_film, String orderId,String customerName,String cardNumber,String expiryMonth,String expiryYear,String cvv);


}
