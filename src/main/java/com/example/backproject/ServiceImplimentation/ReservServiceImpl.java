package com.example.backproject.ServiceImplimentation;


import com.example.backproject.Services.ReservationService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
@Service
public class ReservServiceImpl implements ReservationService {
    public void payer(String nom_film, String orderId,String customerName,String cardNumber,String expiryMonth,String expiryYear,String cvv){
        // URL passerelle de paiement
        String paymentUrl = "https://www.example.com/process-payment";
        // Construction du corps de la requête
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        // les champs demandés dans le paiement
        requestBody.add("orderId", orderId);
        requestBody.add("customerName", customerName);
        requestBody.add("cardNumber", cardNumber);
        requestBody.add("expiryMonth", expiryMonth);
        requestBody.add("expiryYear", expiryYear);
        requestBody.add("cvv", cvv);
        // Configuration des en-têtes de la requête
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        // Création de l'objet HttpEntity avec le corps et les en-têtes
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);
        // Envoi de la requête POST et récupération de la réponse
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(paymentUrl, HttpMethod.POST, requestEntity, String.class);

        // Traitement de la réponse
        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();
            System.out.println("Réponse du paiement : " + responseBody);
        } else {
            System.out.println("Erreur lors du paiement. Code de statut : " + response.getStatusCodeValue()+"stp de verifier vos cordonnées !");
        }
    }
}
