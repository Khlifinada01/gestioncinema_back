package com.example.backproject.Repository;


import com.example.backproject.Domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person,Long> {



    Person getUserByEmail(String email);

    @Query("DELETE from  Reservation_film f where f.reservation_ref=:ref_reservation")
            // */AND  Person.email in  (select p.email from Person p where p.email=:email )/*")
    void deleteReservation(@Param("ref_reservation") String ref_reservation);
}
